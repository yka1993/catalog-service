package kr.co.tcnkorea.catalogservice.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

/**
 * Created by jhpark on 2025-07-17
 */
public record Book(
   @NotBlank(message = "The book ISBN must be defined")
   @Pattern(regexp="^([0-9]{10}|[0-9]{13})$", message = "The ISBN format must be valid.")
   String isbn,
   @NotBlank(message = "The book title must be defined")
   String title,
   @NotBlank(message = "The author title must be defined")
   String author,
   @NotNull(message = "The price title must be defined")
   @Positive(message = "The book price must be greater than zero.")
   Double price
) {}
