package com.epam.messenger.user.management.service.impl;

import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

  @Override
  public String getCurrentAuditor() {
    return "default_auditor";
  }

}
