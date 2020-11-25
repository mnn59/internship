package ir.asta.training.greeting.service;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpokesmanImpl implements Spokesman {
    @Override
    public String greet(String user, String honorific) {
        String space = " ";
        String refinedUsername = refineUserName(user);
        String refinedHonorific = refineHonorific(honorific);
        String msg = "Hello" + space + refinedHonorific + space + refinedUsername + "!";
        log.info(msg);
        return msg;
    }

    private String refineUserName(String user) {
        return getNonEmptyStringOrDefault(user, "User");
    }

    private String refineHonorific(String honorific) {
        return getNonEmptyStringOrDefault(honorific, "dear");
    }

    private String getNonEmptyStringOrDefault(String string, String defaultValue) {
        if (!StringUtils.hasText(string)) {
            string = defaultValue;
        }
        return string;
    }

}
