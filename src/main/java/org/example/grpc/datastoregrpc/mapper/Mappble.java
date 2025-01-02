package org.example.grpc.datastoregrpc.mapper;

public interface Mappble<E, T> {
    T toDto(E e);
}
