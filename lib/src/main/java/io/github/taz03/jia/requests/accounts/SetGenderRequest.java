package io.github.taz03.jia.requests.accounts;

import java.util.Map;

import io.github.taz03.jia.requests.InstagramPostRequest;
import io.github.taz03.jia.responses.InstagramResponse;

/**
 * Represents an Instagram set gender request, used to set gender.
 * <br><br>
 * Endpoint: <i>/accounts/set_gender/</i>
 */
public final class SetGenderRequest extends InstagramPostRequest<InstagramResponse> {
    public static enum Gender {
        MALE(1),
        FEMALE(2),
        PREFER_NOT_TO_SAY(3);

        private final int code; // gender code instagram understands

        private Gender(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    private static final Class<InstagramResponse> RESPONSE_CLASS = InstagramResponse.class;
    private static final String PATH = "/accounts/set_gender/";

    /**
     * Creates a set gender request for provided gender.
     *
     * @param gender The new gender to set
     */
    public SetGenderRequest(Gender gender) {
        super(RESPONSE_CLASS, PATH, null, payload(gender.getCode(), ""));
    }

    /**
     * Creates a set gender request for provided customGender.
     *
     * @param customGender The new custom gender to set
     */
    public SetGenderRequest(String customGender) {
        super(RESPONSE_CLASS, PATH, null, payload(4, customGender));
    }

    private static Map<String, Object> payload(int genderCode, String customGender) {
        return Map.of(
            "gender", genderCode,
            "custom_gender", customGender
        );
    }
}
