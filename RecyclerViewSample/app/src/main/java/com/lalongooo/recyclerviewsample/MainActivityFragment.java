package com.lalongooo.recyclerviewsample;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lalongooo.recyclerviewsample.adapter.MyAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }


    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(new String [] {  "Afghanistan",  "Aland Islands",  "Albania",  "Algeria",  "American Samoa",  "AndorrA",  "Angola",  "Anguilla",  "Antarctica",  "Antigua and Barbuda",  "Argentina",  "Armenia",  "Aruba",  "Australia",  "Austria",  "Azerbaijan",  "Bahamas",  "Bahrain",  "Bangladesh",  "Barbados",  "Belarus",  "Belgium",  "Belize",  "Benin",  "Bermuda",  "Bhutan",  "Bolivia",  "Bosnia and Herzegovina",  "Botswana",  "Bouvet Island",  "Brazil",  "British Indian Ocean Territory",  "Brunei Darussalam",  "Bulgaria",  "Burkina Faso",  "Burundi",  "Cambodia",  "Cameroon",  "Canada",  "Cape Verde",  "Cayman Islands",  "Central African Republic",  "Chad",  "Chile",  "China",  "Christmas Island",  "Cocos (Keeling) Islands",  "Colombia",  "Comoros",  "Congo",  "Congo, The Democratic Republic of the",  "Cook Islands",  "Costa Rica",  "Cote D\'Ivoire",  "Croatia",  "Cuba",  "Cyprus",  "Czech Republic",  "Denmark",  "Djibouti",  "Dominica",  "Dominican Republic",  "Ecuador",  "Egypt",  "El Salvador",  "Equatorial Guinea",  "Eritrea",  "Estonia",  "Ethiopia",  "Falkland Islands (Malvinas",  "Faroe Islands",  "Fiji",  "Finland",  "France",  "French Guiana",  "French Polynesia",  "French Southern Territories",  "Gabon",  "Gambia",  "Georgia",  "Germany",  "Ghana",  "Gibraltar",  "Greece",  "Greenland",  "Grenada",  "Guadeloupe",  "Guam",  "Guatemala",  "Guernsey",  "Guinea",  "Guinea-Bissau",  "Guyana",  "Haiti",  "Heard Island and Mcdonald Islands",  "Holy See (Vatican City State",  "Honduras",  "Hong Kong",  "Hungary",  "Iceland",  "India",  "Indonesia",  "Iran, Islamic Republic Of",  "Iraq",  "Ireland",  "Isle of Man",  "Israel",  "Italy",  "Jamaica",  "Japan",  "Jersey",  "Jordan",  "Kazakhstan",  "Kenya",  "Kiribati",  "Korea, Democratic People\'S Republic of",  "Korea, Republic of",  "Kuwait",  "Kyrgyzstan",  "Lao People\'S Democratic Republic",  "Latvia",  "Lebanon",  "Lesotho",  "Liberia",  "Libyan Arab Jamahiriya",  "Liechtenstein",  "Lithuania",  "Luxembourg",  "Macao",  "Macedonia, The Former Yugoslav Republic of",  "Madagascar",  "Malawi",  "Malaysia",  "Maldives",  "Mali",  "Malta",  "Marshall Islands",  "Martinique",  "Mauritania",  "Mauritius",  "Mayotte",  "Mexico",  "Micronesia, Federated States of",  "Moldova, Republic of",  "Monaco",  "Mongolia",  "Montserrat",  "Morocco",  "Mozambique",  "Myanmar",  "Namibia",  "Nauru",  "Nepal",  "Netherlands",  "Netherlands Antilles",  "New Caledonia",  "New Zealand",  "Nicaragua",  "Niger",  "Nigeria",  "Niue",  "Norfolk Island",  "Northern Mariana Islands",  "Norway",  "Oman",  "Pakistan",  "Palau",  "Palestinian Territory, Occupied",  "Panama",  "Papua New Guinea",  "Paraguay",  "Peru",  "Philippines",  "Pitcairn",  "Poland",  "Portugal",  "Puerto Rico",  "Qatar",  "Reunion",  "Romania",  "Russian Federation",  "RWANDA",  "Saint Helena",  "Saint Kitts and Nevis",  "Saint Lucia",  "Saint Pierre and Miquelon",  "Saint Vincent and the Grenadines",  "Samoa",  "San Marino",  "Sao Tome and Principe",  "Saudi Arabia",  "Senegal",  "Serbia and Montenegro",  "Seychelles",  "Sierra Leone",  "Singapore",  "Slovakia",  "Slovenia",  "Solomon Islands",  "Somalia",  "South Africa",  "South Georgia and the South Sandwich Islands",  "Spain",  "Sri Lanka",  "Sudan",  "Suriname",  "Svalbard and Jan Mayen",  "Swaziland",  "Sweden",  "Switzerland",  "Syrian Arab Republic",  "Taiwan, Province of China",  "Tajikistan",  "Tanzania, United Republic of",  "Thailand",  "Timor-Leste",  "Togo",  "Tokelau",  "Tonga",  "Trinidad and Tobago",  "Tunisia",  "Turkey",  "Turkmenistan",  "Turks and Caicos Islands",  "Tuvalu",  "Uganda",  "Ukraine",  "United Arab Emirates",  "United Kingdom",  "United States",  "United States Minor Outlying Islands",  "Uruguay",  "Uzbekistan",  "Vanuatu",  "Venezuela",  "Viet Nam",  "Virgin Islands, British",  "Virgin Islands, U.S",  "Wallis and Futuna",  "Western Sahara",  "Yemen",  "Zambia",  "Zimbabwe"});
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }
}
