package com.linewell.license.platform.common.translate.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Description 类描述
 *
 * @author luolifeng
 * @version 1.0.0
 * Date 2019-08-06
 * Time 16:53
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TranslateObject {
        private String language;
        private String code;
        private List<ParamObject> params;
}
