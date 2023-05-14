package com.zara.technical.application.controller;

import com.zara.technical.application.port.primary.PricePrimaryPort;
import com.zara.technical.domain.dto.PriceDTO;
import com.zara.technical.domain.exception.NotFoundPriceException;
import com.zara.technical.domain.service.PriceService;
import com.zara.technical.domain.vo.PriceData;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ApiOperation(
    value = "Retrieve prices data for given params",
    nickname = "Get Price's data",
    notes = "Retrieve price's: product and brand identifiers, final price and its valid dates. "
        + "Get desired price from params: date to apply, product and brand identifiers.",
    response = ResponseEntity.class, tags = {"Price",})
@RequestMapping("/prices")
public class PriceController implements PricePrimaryPort {

  private final PriceService priceService;

  @Autowired
  public PriceController(final PriceService priceService) {
    this.priceService = priceService;
  }

  @Override
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "OK", response = ResponseEntity.class),
      @ApiResponse(code = 404, message = "Not Found", response = NotFoundPriceException.class)})
  @GetMapping(value = "/price/{brandId}/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public PriceDTO getPriceDataForGivenBrandProductIdAndDate(
      @ApiParam(value = "Brand identifier.") @PathVariable final Long brandId,
      @ApiParam(value = "Product identifier.") @PathVariable final Long productId,
      @ApiParam(value = "Date on which the query applies") @RequestBody final String date) {
    final List<PriceData> priceDataList =
        priceService.getPriceDataForGivenBrandProductIdAndDate(brandId, productId, date);

    final PriceDTO dto = new PriceDTO();
    dto.setPriceDataList(priceDataList);
    return dto;
  }

}
