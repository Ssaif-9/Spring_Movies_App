package com.ssultan.movieapp.model.response;

import java.util.List;

public class PageResponse <T>{
    private Integer totalPages;
    private Long totalElements;
    private List<T> entity;

    public PageResponse() {}

    public PageResponse(Integer totalPages, Long totalElements, List<T> entity) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.entity = entity;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<?> getEntity() {
        return entity;
    }

    public void setEntity(List<T> entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return "PageResponse{" +
                "totalPages=" + totalPages +
                ", totalElements=" + totalElements +
                ", entity=" + entity +
                '}';
    }
}
