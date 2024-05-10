package com.example.souq.Model.Entity;

import com.example.souq.Class.DTO.CategoryDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table
@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;

    public static Category toCategory(CategoryDTO dto) {
        return Category.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
