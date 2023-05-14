package com.zara.technical.application.port.secondary;

import com.zara.technical.domain.entity.PriceEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<PriceEntity, Long> {

  Optional<List<PriceEntity>> findByBrandIdAndProductId(final Long brandId, final Long productId);

}
