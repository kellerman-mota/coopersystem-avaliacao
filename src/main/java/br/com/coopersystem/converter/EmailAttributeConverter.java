package br.com.coopersystem.converter;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.*;

@Converter
public class EmailAttributeConverter implements AttributeConverter<Set<String>, String> {
    @Override
    public String convertToDatabaseColumn(Set<String> emails) {
        if (CollectionUtils.isEmpty(emails)) return "";
        return String.join(";", emails);
    }

    @Override
    public Set<String> convertToEntityAttribute(String s) {
        if (StringUtils.isEmpty(s)) return new HashSet<>();
        return new HashSet<>(Arrays.asList(s.split(";")));
    }
}
