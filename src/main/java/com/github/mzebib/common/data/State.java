package com.github.mzebib.common.data;

import com.github.mzebib.common.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mzebib
 */
public enum State {
    ALABAMA("Alabama", "AL", "Ala."),
    ALASKA("Alaska", "AK", "Alaska"),
    ARIZONA("Arizona", "AZ", "Ariz."),
    ARKANSAS("Arkansas", "AR", "Ark."),
    CALIFORNIA("California", "CA", "Calif."),
    COLORADO("Colorado", "CO", "Colo."),
    CONNECTICUT("Connecticut", "CT", "Conn."),
    DELAWARE("Delaware", "DE", "Del."),
    DISTRICT_OF_COLUMBIA("District of Columbia", "DC", "D.C."),
    FLORIDA("Florida", "FL", "Fla."),
    GEORGIA("Georgia", "GA", "Ga."),
    HAWAII("Hawaii", "HI", "Hawaii"),
    IDAHO("Idaho", "ID", "Idaho"),
    ILLINOIS("Illinois", "IL", "Ill."),
    INDIANA("Indiana", "IN", "Ind."),
    IOWA("Iowa", "IA", "Iowa"),
    KANSAS("Kansas", "KS", "Kans."),
    KENTUCKY("Kentucky", "KY", "Ky."),
    LOUISIANA("Louisiana", "LA", "La."),
    MAINE("Maine", "ME", "Maine"),
    MARYLAND("Maryland", "MD", "Md."),
    MASSACHUSETTS("Massachusetts", "MA", "Mass."),
    MICHIGAN("Michigan", "MI", "Mich."),
    MINNESOTA("Minnesota", "MN", "Minn."),
    MISSISSIPPI("Mississippi", "MS", "Miss."),
    MISSOURI("Missouri", "MO", "Mo."),
    MONTANA("Montana", "MT", "Mont."),
    NEBRASKA("Nebraska", "NE", "Nebr."),
    NEVADA("Nevada", "NV", "Nev."),
    NEW_HAMPSHIRE("New Hampshire", "NH", "N.H."),
    NEW_JERSEY("New Jersey", "NJ", "N.J."),
    NEW_MEXICO("New Mexico", "NM", "N.M."),
    NEW_YORK("New York", "NY", "N.Y."),
    NORTH_CAROLINA("North Carolina", "NC", "N.C."),
    NORTH_DAKOTA("North Dakota", "ND", "N.D."),
    OHIO("Ohio", "OH", "Ohio"),
    OKLAHOMA("Oklahoma", "OK", "Okla."),
    OREGON("Oregon", "OR", "Ore."),
    PENNSYLVANIA("Pennsylvania", "PA", "Pa."),
    RHODE_ISLAND("Rhode Island", "RI", "R.I."),
    SOUTH_CAROLINA("South Carolina", "SC", "S.C."),
    SOUTH_DAKOTA("South Dakota", "SD", "S.D."),
    TENNESSEE("Tennessee", "TN", "Tenn."),
    TEXAS("Texas", "TX", "Tex."),
    UTAH("Utah", "UT", "Utah"),
    VERMONT("Vermont", "VT", "Vt."),
    VIRGINIA("Virginia", "VA", "Va."),
    WASHINGTON("Washington", "WA", "Wash."),
    WEST_VIRGINIA("West Virginia", "WV", "W.Va."),
    WISCONSIN("Wisconsin", "WI", "Wis."),
    WYOMING("Wyoming", "WY", "Wyo."),

    AMERICAN_SAMOA("American Samoa", "AS", null),
    GUAM("Guam", "GU", "Guam"),
    NORTHERN_MARIANA_ISLANDS("Northern Mariana Islands", "MP", null),
    PUERTO_RICO("Puerto Rico", "PR", "P.R."),
    US_VIRGIN_ISLANDS("U.S. Virgin Islands", "VI", null)
    ;

    private final String name;
    private final String code;
    private final String abbreviation;

    private static final Map<String, State> STATE_NAMES = new HashMap<>();
    private static final Map<String, State> STATE_CODES = new HashMap<>();
    private static final Map<String, State> STATE_ABBREV = new HashMap<>();

    static {
        for (State state : values()) {
            if (state.getName() != null) {
                STATE_NAMES.put(state.getName().toLowerCase(), state);
            }
        }

        for (State state : values()) {
            if (state.getCode() != null) {
                STATE_CODES.put(state.getCode().toLowerCase(), state);
            }
        }

        for (State state : values()) {
            if (state.getAbbreviation() != null) {
                STATE_ABBREV.put(state.getAbbreviation().toLowerCase(), state);
            }
        }
    }

    State(String name, String code, String abbreviation) {
        this.name = name;
        this.code = code;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @Override
    public String toString() {
        return name;
    }

    public static State lookup(String str) {
        if (!StringUtil.isEmpty(str)) {
            str = str.toLowerCase();

            State state = STATE_CODES.get(str);
            if (state == null) {
                state = STATE_NAMES.get(str);
            }

            if (state == null) {
                state = STATE_ABBREV.get(str);
            }

            return state;
        }

        return null;
    }

    public static Map<String, State> getStateNames() {
        return STATE_NAMES;
    }

    public static Map<String, State> getStateCodes() {
        return STATE_CODES;
    }

    public static Map<String, State> getStateAbbreviations() {
        return STATE_ABBREV;
    }

}
