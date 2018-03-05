package com.hanquez.feedfetcher.impl.converter;

import com.hanquez.feedfetcher.api.converter.EntryConverter;
import com.rometools.rome.feed.synd.SyndEntry;

public class SyndEntryConverter implements EntryConverter<SyndEntry> {
    @Override
    public SyndEntry convert(SyndEntry entry) {
        return entry;
    }
}
