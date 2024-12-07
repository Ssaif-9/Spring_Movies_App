package com.ssultan.movieapp.model;

import java.util.List;

public class PageResponse <T>{
    private Integer totalPages;
    private Long totalElements;
    private List<?> entity;

    public PageResponse() {}

    public PageResponse(Integer totalPages, Long totalElements, List<?> entity) {
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

    public void setEntity(List<?> entity) {
        this.entity = entity;
    }
}
