package dev.naimsulejmani.grupi2bookcheckmark.enums;

import lombok.Getter;

@Getter
public enum Rating {
    // \u2605 \u2606
    ZERO_STAR(0, "☆☆☆☆☆"),
    ONE_STAR(1, "★☆☆☆☆"),
    TWO_STAR(2, "★★☆☆☆"),
    THREE_STAR(3, "★★★☆☆"),
    FOUR_STAR(4, "★★★★☆"),
    FIVE_STAR(5, "★★★★★");

    private final int value;
    private final String stars;

    Rating(int value, String stars) {
        this.value = value;
        this.stars = stars;
    }
}
