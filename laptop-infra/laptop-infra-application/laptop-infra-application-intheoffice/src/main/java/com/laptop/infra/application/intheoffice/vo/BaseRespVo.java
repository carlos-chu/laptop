package com.laptop.infra.application.intheoffice.vo;

import com.laptop.infra.application.intheoffice.util.JsonUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseRespVo {
  @Builder.Default
  private String status = "success";
  private String code;
  private String message;
  private Object data;

  @Override
  public String toString() {
    return JsonUtil.toJsonString(this);
  }
  
}
