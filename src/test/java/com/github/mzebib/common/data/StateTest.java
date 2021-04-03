package com.github.mzebib.common.data;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

/**
 * @author mzebib
 */
public class StateTest {

    @Test
    public void testLookup() {
        assertEquals(State.ALABAMA, State.lookup("AL"));
        assertEquals(State.ALABAMA, State.lookup("Alabama"));
        assertEquals(State.ALABAMA, State.lookup("Ala."));

        assertEquals(State.ALASKA, State.lookup("AK"));
        assertEquals(State.ALASKA, State.lookup("Alaska"));

        assertEquals(State.ARIZONA, State.lookup("AZ"));
        assertEquals(State.ARIZONA, State.lookup("Arizona"));
        assertEquals(State.ARIZONA, State.lookup("Ariz."));


        assertEquals(State.ARKANSAS, State.lookup("AR"));
        assertEquals(State.ARKANSAS, State.lookup("Arkansas"));
        assertEquals(State.ARKANSAS, State.lookup("Ark."));

        assertEquals(State.CALIFORNIA, State.lookup("CA"));
        assertEquals(State.CALIFORNIA, State.lookup("California"));
        assertEquals(State.CALIFORNIA, State.lookup("Calif."));

        assertEquals(State.COLORADO, State.lookup("CO"));
        assertEquals(State.COLORADO, State.lookup("Colorado"));
        assertEquals(State.COLORADO, State.lookup("Colo."));

        assertEquals(State.CONNECTICUT, State.lookup("CT"));
        assertEquals(State.CONNECTICUT, State.lookup("Connecticut"));
        assertEquals(State.CONNECTICUT, State.lookup("Conn."));

        assertEquals(State.DELAWARE, State.lookup("DE"));
        assertEquals(State.DELAWARE, State.lookup("Delaware"));
        assertEquals(State.DELAWARE, State.lookup("Del."));

        assertEquals(State.DISTRICT_OF_COLUMBIA, State.lookup("DC"));
        assertEquals(State.DISTRICT_OF_COLUMBIA, State.lookup("District of Columbia"));
        assertEquals(State.DISTRICT_OF_COLUMBIA, State.lookup("D.C."));

        assertEquals(State.FLORIDA, State.lookup("FL"));
        assertEquals(State.FLORIDA, State.lookup("Florida"));
        assertEquals(State.FLORIDA, State.lookup("Fla."));

        assertEquals(State.GEORGIA, State.lookup("GA"));
        assertEquals(State.GEORGIA, State.lookup("Georgia"));
        assertEquals(State.GEORGIA, State.lookup("Ga."));

        assertEquals(State.HAWAII, State.lookup("HI"));
        assertEquals(State.HAWAII, State.lookup("Hawaii"));

        assertEquals(State.IDAHO, State.lookup("ID"));
        assertEquals(State.IDAHO, State.lookup("Idaho"));

        assertEquals(State.ILLINOIS, State.lookup("IL"));
        assertEquals(State.ILLINOIS, State.lookup("Illinois"));
        assertEquals(State.ILLINOIS, State.lookup("Ill."));

        assertEquals(State.INDIANA, State.lookup("IN"));
        assertEquals(State.INDIANA, State.lookup("Indiana"));
        assertEquals(State.INDIANA, State.lookup("Ind."));

        assertEquals(State.IOWA, State.lookup("IA"));
        assertEquals(State.IOWA, State.lookup("Iowa"));

        assertEquals(State.KANSAS, State.lookup("KS"));
        assertEquals(State.KANSAS, State.lookup("Kansas"));
        assertEquals(State.KANSAS, State.lookup("Kans."));

        assertEquals(State.KENTUCKY, State.lookup("KY"));
        assertEquals(State.KENTUCKY, State.lookup("Kentucky"));
        assertEquals(State.KENTUCKY, State.lookup("Ky."));

        assertEquals(State.LOUISIANA, State.lookup("LA"));
        assertEquals(State.LOUISIANA, State.lookup("Louisiana"));
        assertEquals(State.LOUISIANA, State.lookup("La."));

        assertEquals(State.MAINE, State.lookup("ME"));
        assertEquals(State.MAINE, State.lookup("Maine"));

        assertEquals(State.MARYLAND, State.lookup("MD"));
        assertEquals(State.MARYLAND, State.lookup("Maryland"));
        assertEquals(State.MARYLAND, State.lookup("Md."));

        assertEquals(State.MASSACHUSETTS, State.lookup("MA"));
        assertEquals(State.MASSACHUSETTS, State.lookup("Massachusetts"));
        assertEquals(State.MASSACHUSETTS, State.lookup("Mass."));

        assertEquals(State.MICHIGAN, State.lookup("MI"));
        assertEquals(State.MICHIGAN, State.lookup("Michigan"));
        assertEquals(State.MICHIGAN, State.lookup("Mich."));

        assertEquals(State.MISSISSIPPI, State.lookup("MS"));
        assertEquals(State.MISSISSIPPI, State.lookup("Mississippi"));
        assertEquals(State.MISSISSIPPI, State.lookup("Miss."));

        assertEquals(State.MISSOURI, State.lookup("MO"));
        assertEquals(State.MISSOURI, State.lookup("Missouri"));
        assertEquals(State.MISSOURI, State.lookup("Mo."));

        assertEquals(State.MONTANA, State.lookup("MT"));
        assertEquals(State.MONTANA, State.lookup("Montana"));
        assertEquals(State.MONTANA, State.lookup("Mont."));

        assertEquals(State.NEBRASKA, State.lookup("NE"));
        assertEquals(State.NEBRASKA, State.lookup("Nebraska"));
        assertEquals(State.NEBRASKA, State.lookup("Nebr."));

        assertEquals(State.NEVADA, State.lookup("NV"));
        assertEquals(State.NEVADA, State.lookup("Nevada"));
        assertEquals(State.NEVADA, State.lookup("Nev."));

        assertEquals(State.NEW_HAMPSHIRE, State.lookup("NH"));
        assertEquals(State.NEW_HAMPSHIRE, State.lookup("New Hampshire"));
        assertEquals(State.NEW_HAMPSHIRE, State.lookup("N.H."));

        assertEquals(State.NEW_JERSEY, State.lookup("NJ"));
        assertEquals(State.NEW_JERSEY, State.lookup("New Jersey"));
        assertEquals(State.NEW_JERSEY, State.lookup("N.J."));

        assertEquals(State.NEW_MEXICO, State.lookup("NM"));
        assertEquals(State.NEW_MEXICO, State.lookup("New Mexico"));
        assertEquals(State.NEW_MEXICO, State.lookup("N.M."));

        assertEquals(State.NEW_YORK, State.lookup("NY"));
        assertEquals(State.NEW_YORK, State.lookup("New York"));
        assertEquals(State.NEW_YORK, State.lookup("N.Y."));

        assertEquals(State.NORTH_CAROLINA, State.lookup("NC"));
        assertEquals(State.NORTH_CAROLINA, State.lookup("North Carolina"));
        assertEquals(State.NORTH_CAROLINA, State.lookup("N.C."));

        assertEquals(State.NORTH_DAKOTA, State.lookup("ND"));
        assertEquals(State.NORTH_DAKOTA, State.lookup("North Dakota"));
        assertEquals(State.NORTH_DAKOTA, State.lookup("N.D."));

        assertEquals(State.OHIO, State.lookup("OH"));
        assertEquals(State.OHIO, State.lookup("Ohio"));

        assertEquals(State.OKLAHOMA, State.lookup("OK"));
        assertEquals(State.OKLAHOMA, State.lookup("Oklahoma"));
        assertEquals(State.OKLAHOMA, State.lookup("Okla."));

        assertEquals(State.OREGON, State.lookup("OR"));
        assertEquals(State.OREGON, State.lookup("Oregon"));
        assertEquals(State.OREGON, State.lookup("Ore."));

        assertEquals(State.PENNSYLVANIA, State.lookup("PA"));
        assertEquals(State.PENNSYLVANIA, State.lookup("Pennsylvania"));
        assertEquals(State.PENNSYLVANIA, State.lookup("Pa."));

        assertEquals(State.RHODE_ISLAND, State.lookup("RI"));
        assertEquals(State.RHODE_ISLAND, State.lookup("Rhode Island"));
        assertEquals(State.RHODE_ISLAND, State.lookup("R.I."));

        assertEquals(State.SOUTH_CAROLINA, State.lookup("SC"));
        assertEquals(State.SOUTH_CAROLINA, State.lookup("South Carolina"));
        assertEquals(State.SOUTH_CAROLINA, State.lookup("S.C."));

        assertEquals(State.SOUTH_DAKOTA, State.lookup("SD"));
        assertEquals(State.SOUTH_DAKOTA, State.lookup("South Dakota"));
        assertEquals(State.SOUTH_DAKOTA, State.lookup("S.D."));

        assertEquals(State.TENNESSEE, State.lookup("TN"));
        assertEquals(State.TENNESSEE, State.lookup("Tennessee"));
        assertEquals(State.TENNESSEE, State.lookup("Tenn."));

        assertEquals(State.TEXAS, State.lookup("TX"));
        assertEquals(State.TEXAS, State.lookup("Texas"));
        assertEquals(State.TEXAS, State.lookup("Tex."));

        assertEquals(State.UTAH, State.lookup("UT"));
        assertEquals(State.UTAH, State.lookup("Utah"));

        assertEquals(State.VERMONT, State.lookup("VT"));
        assertEquals(State.VERMONT, State.lookup("Vermont"));
        assertEquals(State.VERMONT, State.lookup("Vt."));

        assertEquals(State.VIRGINIA, State.lookup("VA"));
        assertEquals(State.VIRGINIA, State.lookup("Virginia"));
        assertEquals(State.VIRGINIA, State.lookup("Va."));

        assertEquals(State.WASHINGTON, State.lookup("WA"));
        assertEquals(State.WASHINGTON, State.lookup("Washington"));
        assertEquals(State.WASHINGTON, State.lookup("Wash."));

        assertEquals(State.WEST_VIRGINIA, State.lookup("WV"));
        assertEquals(State.WEST_VIRGINIA, State.lookup("West Virginia"));
        assertEquals(State.WEST_VIRGINIA, State.lookup("W.Va."));

        assertEquals(State.WISCONSIN, State.lookup("WI"));
        assertEquals(State.WISCONSIN, State.lookup("Wisconsin"));
        assertEquals(State.WISCONSIN, State.lookup("Wis."));

        assertEquals(State.WYOMING, State.lookup("WY"));
        assertEquals(State.WYOMING, State.lookup("Wyoming"));
        assertEquals(State.WYOMING, State.lookup("Wyo."));

        assertEquals(State.AMERICAN_SAMOA, State.lookup("AS"));
        assertEquals(State.AMERICAN_SAMOA, State.lookup("American Samoa"));

        assertEquals(State.GUAM, State.lookup("GU"));
        assertEquals(State.GUAM, State.lookup("Guam"));

        assertEquals(State.NORTHERN_MARIANA_ISLANDS, State.lookup("MP"));
        assertEquals(State.NORTHERN_MARIANA_ISLANDS, State.lookup("Northern Mariana Islands"));

        assertEquals(State.PUERTO_RICO, State.lookup("PR"));
        assertEquals(State.PUERTO_RICO, State.lookup("Puerto Rico"));
        assertEquals(State.PUERTO_RICO, State.lookup("P.R."));

        assertEquals(State.US_VIRGIN_ISLANDS, State.lookup("VI"));
        assertEquals(State.US_VIRGIN_ISLANDS, State.lookup("U.S. Virgin Islands"));

        assertNull(null, State.lookup(null));
        assertNull(null, State.lookup(""));
    }

}
