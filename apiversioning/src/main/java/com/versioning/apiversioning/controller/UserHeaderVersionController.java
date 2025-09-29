package com.versioning.apiversioning.controller;
 import com.versioning.apiversioning.dto.UserV1;
import com.versioning.apiversioning.dto.UserV2;
import com.versioning.apiversioning.exception.UnsupportedVersionException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserHeaderVersionController {

    @Value("${api.version.header-name}")
    private String headerName;

    @Value("${api.version.v1}")
    private String version1;

    @Value("${api.version.v2}")
    private String version2;

    @Value("${api.version.default}")
    private String defaultVersion;

    @GetMapping
    public Object getUserBasedOnHeader(@RequestHeader(value = "X-API-VERSION", required = false) String version) {
        if (version == null || version.isEmpty()) {
            version = defaultVersion;
        }

        if (version.equals(version1)) {
            return new UserV1("Satya Pentakoti");
        } else if (version.equals(version2)) {
            return new UserV2("Satya", "Pentakoti");
        } else {
            throw new UnsupportedVersionException(version);
        }
    }
}
