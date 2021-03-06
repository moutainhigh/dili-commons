package com.dili.commons.controller;

import cn.hutool.core.util.NumberUtil;
import com.dili.ss.metadata.ValuePair;
import com.dili.ss.metadata.ValuePairImpl;
import com.dili.ss.metadata.ValueProviderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * vue element form provider
 */
@RestController
@RequestMapping({"/convert"})
public class ConvertController {

    @Autowired
    private ValueProviderUtils valueProviderUtils;

    public ConvertController() {
    }

    /**
     * list
     *
     * @param queryMap
     * @return
     */
    @PostMapping({"/list.action"})
    public List<ValuePair<?>> getLookupList(@RequestBody Map<String, Object> queryMap) {
        String provider = queryMap.get("provider").toString();
        boolean typeString = false;
        if (queryMap.get("stringValue") != null) {
            typeString = Boolean.parseBoolean(queryMap.get("stringValue").toString());
        }
        List result = new ArrayList<ValuePair<?>>();
        queryMap.remove("provider");
        List<ValuePair<?>> value = this.valueProviderUtils.getLookupList(provider, queryMap.get("value"), queryMap);
        boolean finalTypeString = typeString;
        value.forEach(valuePair -> {
            if (NumberUtil.isNumber(valuePair.getValue().toString()) && !finalTypeString) {
                result.add(new ValuePairImpl(valuePair.getText(), Long.valueOf(valuePair.getValue().toString())));
            } else {
                result.add(valuePair);
            }
        });
        return result;
    }
}
