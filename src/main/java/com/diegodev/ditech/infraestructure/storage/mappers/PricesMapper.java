package com.diegodev.ditech.infraestructure.storage.mappers;

import com.diegodev.ditech.domain.models.Prices;
import com.diegodev.ditech.infraestructure.storage.entities.PricesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface PricesMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "brandId", source = "brandId")
    @Mapping(target = "startDate", source = "startDate")
    @Mapping(target = "endDate", source = "endDate")
    @Mapping(target = "priceList", source = "priceList")
    @Mapping(target = "productId", source = "productId")
    @Mapping(target = "priority", source = "priority")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "curr", source = "curr")
    Prices toPrices(PricesEntity pricesEntity);

    default List<Prices> toPrices(List<PricesEntity> pricesEntityList) {
        return CollectionUtils.isEmpty(pricesEntityList) ? new ArrayList<>() : pricesEntityList.stream().map(this::toPrices).collect(Collectors.toList());
    }

}