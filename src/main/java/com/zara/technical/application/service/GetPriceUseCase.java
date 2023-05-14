package com.zara.technical.application.service;

import com.zara.technical.application.port.secondary.PriceRepository;
import com.zara.technical.domain.entity.PriceEntity;
import com.zara.technical.domain.exception.NotFoundPriceException;
import com.zara.technical.domain.service.PriceService;
import com.zara.technical.domain.vo.PriceConstants;
import com.zara.technical.domain.vo.PriceData;
import com.zara.technical.domain.vo.Priority;
import com.zara.technical.infrastructure.mapper.PriceMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPriceUseCase implements PriceService {

  private final PriceRepository priceRepo;

  private final PriceMapper priceMapper;

  @Autowired
  public GetPriceUseCase(final PriceRepository priceRepo, final PriceMapper priceMapper) {
    this.priceRepo = priceRepo;
    this.priceMapper = priceMapper;
  }

  @Override
  public List<PriceData> getPriceDataForGivenBrandProductIdAndDate(final Long brand,
      final Long productId, final String date) {
    // basic defending programming
    checkParams(brand, productId, date);

    // retrieve results for given brand and product params
    final List<PriceEntity> priceEntityList = priceRepo.findByBrandIdAndProductId(brand, productId)
        .orElseThrow(NotFoundPriceException::new);

    // apply filter logic and transform to response type
    return mapEntityListToDataList(filterAndValidateResult(priceEntityList, date));
  }

  private void checkParams(final Long brand, final Long productId, final String date) {
    if (brand == null || productId == null || date == null) {
      throw new NotFoundPriceException("Some of the given params are not valid.");
    }
  }

  private List<PriceEntity> filterAndValidateResult(List<PriceEntity> priceEntityList,
      String date) {
    List<PriceEntity> filteredList = filterByDate(priceEntityList, mapStringToLocalDateTime(date));

    filteredList = (isMultipleResult(filteredList) ? filterByHighPriority(filteredList) : filteredList);

    if (filteredList.isEmpty()) {
      throw new NotFoundPriceException();
    }

    return filteredList;
  }

  private LocalDateTime mapStringToLocalDateTime(String dateString) {
    dateString = dateString.replace(PriceConstants.DATE_REMOVE_CHAR, PriceConstants.DATE_REPLACE_CHAR);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PriceConstants.DATE_FORMAT);

    try {
      return LocalDateTime.parse(dateString, formatter);
    } catch (Exception err) {
      throw new NotFoundPriceException(
          "Given date parameter is not valid. Check its format and try again.");
    }
  }

  private List<PriceEntity> filterByDate(final List<PriceEntity> priceEntityList, final LocalDateTime date) {
    return priceEntityList.stream()
        .filter(entity -> entity.getStartDate().isBefore(date))
        .filter(entity -> entity.getEndDate().isAfter(date))
        .collect(Collectors.toList());
  }

  private Boolean isMultipleResult(final List<PriceEntity> priceEntityList) {
    return priceEntityList.size() > PriceConstants.SIZE_ONE;
  }

  private List<PriceEntity> filterByHighPriority(final List<PriceEntity> priceEntityList) {
    return priceEntityList.stream()
        .filter(entity -> entity.getPriority().equals(Priority.HIGH.getCode()))
        .collect(Collectors.toList());
  }

  private List<PriceData> mapEntityListToDataList(final List<PriceEntity> priceEntityList) {
    return priceEntityList.stream()
        .map(priceMapper::mapPriceEntityToData)
        .collect(Collectors.toList());
  }

}
