package edu.raijin.commons.domain.model;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

import org.springframework.data.domain.Page;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Paged<T> implements Iterable<T> {

    private int page;

    private int size;

    private int totalItems;

    private int totalPages;

    private boolean lastPage;

    private boolean firstPage;

    private List<T> items;

    public static <T> Paged<T> from(Page<T> page) {
        return Paged.<T>builder()
                .page(page.getNumber())
                .size(page.getSize())
                .totalItems((int) page.getTotalElements())
                .totalPages(page.getTotalPages())
                .lastPage(page.isLast())
                .firstPage(page.isFirst())
                .items(page.getContent())
                .build();
    }

    public <U> Paged<U> map(Function<T, U> mapper) {
        return Paged.<U>builder()
                .page(page)
                .size(size)
                .totalItems(totalItems)
                .totalPages(totalPages)
                .lastPage(lastPage)
                .firstPage(firstPage)
                .items(items.stream().map(mapper).toList())
                .build();
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}
