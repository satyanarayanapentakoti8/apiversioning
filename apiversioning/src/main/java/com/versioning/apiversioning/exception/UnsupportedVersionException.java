package com.versioning.apiversioning.exception;

public class UnsupportedVersionException extends RuntimeException {
    public UnsupportedVersionException(String version) {
        super("Unsupported API version: " + version);
    }
}
