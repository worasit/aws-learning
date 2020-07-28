package com.daimongkol.aws.openfeign.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Issue {
    String title;
    String body;
    List<String> assignees;
    Integer milestone;
    List<String> labels;
}
