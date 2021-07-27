package com.javastream.spliterator;

import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The {@code Spliterators} class represents split service.
 * It allows us to use chain of splits.
 * <p>
 * For example, this expression:
 * <p>
 * Spliterators spliterator = new Spliterators("Natural Wonders,Wonders of the World,Mount Everest");
 * <p>
 * String res = spliterator.split(",")
 *                 .choice(1)
 *                 .split("of")
 *                 .choice(0)
 *                 .trim()
 *                 .build();
 * <p>
 * And result will be contains "Wonders".
 *
 * @author Serg Melekshayan (JavaStream)
 * @since 1.0
 */

public final class Spliterators {

    private List<String> list = new ArrayList<>();
    private final String EMPTY_STRING = "";
    private final String GIVEN_STRING;


    public Spliterators(@Nonnull String given) {
        Preconditions.checkState(!given.isEmpty(), "Given string is empty.");
        Preconditions.checkNotNull(given, "Given string is null.");

        this.GIVEN_STRING = given;
    }

    /**
     * Splits this string using regular expression.
     *
     * @param regex the delimiting regular expression
     * @return
     */
    public Spliterators split(String regex) {
        if (list.isEmpty()) {
            Collections.addAll(list, GIVEN_STRING.split(regex));
            return this;
        }

        String str = list.get(0);
        list.clear();
        Collections.addAll(list, str.split(regex));
        return this;
    }

    /**
     * Choosing string using its position in the result array after split.
     * If index has wrong value this method returns empty result
     *
     * @param index the position of value in the result array
     * @return
     */
    public Spliterators choice(int index) {
        if (index >= list.size()) {
            list.clear();
            Collections.addAll(list, EMPTY_STRING);
            return this;
        }

        String str = list.get(index);
        list.clear();

        Collections.addAll(list, str);
        return this;
    }

    /**
     * Util method allows remove spaces at the start and end of the string
     *
     * @return Spliterators
     */
    public Spliterators trim() {
        Preconditions.checkState(!list.isEmpty(), "List of values are empty");

        String trim = list.get(0).trim();
        list.clear();
        Collections.addAll(list, trim);
        return this;
    }

    /**
     * @return result string after all methods.
     * If the method choice did not apply return first element of array.
     */
    public String build() {
        Preconditions.checkState(!list.isEmpty(), "List of values are empty");
        return list.get(0);
    }
}