package org.example.grpc.datastoregrpc.mapper;

import org.example.grpc.datastoregrpc.dto.SummaryDto;
import org.example.grpc.datastoregrpc.model.Summary;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappble<Summary, SummaryDto> {
}
