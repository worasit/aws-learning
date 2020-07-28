package com.daimongkol.aws.openfeign;

import com.daimongkol.aws.openfeign.models.Contributor;
import com.daimongkol.aws.openfeign.models.Issue;
import feign.Param;
import feign.RequestLine;

import java.util.List;

public interface GitHub {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

    @RequestLine("POST /repos/{owner}/{repo}/issues")
    void createIssue(Issue issue, @Param("owner") String owner, @Param("repo") String repo);
}
