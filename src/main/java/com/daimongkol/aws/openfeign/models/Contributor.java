package com.daimongkol.aws.openfeign.models;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contributor {
    String login;
    Integer contributions;
    @SerializedName("avatar_url")
    String avatarUrl;
}
