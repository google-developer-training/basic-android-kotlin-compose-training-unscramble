/*
 * Copyright (c) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.sports.data

import com.example.android.sports.R
import com.example.android.sports.model.Sport

/**
 * Sports data
 */
object SportsData{
    fun getSportsData(): ArrayList<Sport> {
        return arrayListOf(
            Sport(
                id = 1,
                titleResourceId = R.string.baseball,
                subTitleResourceId = R.string.baseball_subtitle,
                imageResourceId = R.drawable.icon_baseball,
                sportsImageBanner = R.drawable.img_baseball
            ),
            Sport(
                id = 2, titleResourceId = R.string.badminton,
                subTitleResourceId = R.string.badminton_subtitle,
                imageResourceId = R.drawable.icon_badminton,
                sportsImageBanner = R.drawable.img_badminton
            ),
            Sport(
                id = 3,
                titleResourceId = R.string.basketball,
                subTitleResourceId = R.string.basketball_subtitle,
                imageResourceId = R.drawable.icon_basketball,
                sportsImageBanner = R.drawable.img_basketball
            ),
            Sport(
                id = 4,
                titleResourceId = R.string.bowling,
                subTitleResourceId = R.string.bowling_subtitle,
                imageResourceId = R.drawable.icon_bowling,
                sportsImageBanner = R.drawable.img_bowling
            ),
            Sport(
                id = 5,
                titleResourceId = R.string.cycling,
                subTitleResourceId = R.string.cycling_subtitle,
                imageResourceId = R.drawable.icon_cycling,
                sportsImageBanner = R.drawable.img_cycling
            ),
            Sport(
                id = 6,
                titleResourceId = R.string.golf,
                subTitleResourceId = R.string.golf_subtitle,
                imageResourceId = R.drawable.icon_golf,
                sportsImageBanner = R.drawable.img_golf
            ),
            Sport(
                id = 7,
                titleResourceId = R.string.running,
                subTitleResourceId = R.string.running_subtitle,
                imageResourceId = R.drawable.icon_running,
                sportsImageBanner = R.drawable.img_running
            ),
            Sport(
                id = 8,
                titleResourceId = R.string.soccer,
                subTitleResourceId = R.string.soccer_subtitle,
                imageResourceId = R.drawable.icon_soccer,
                sportsImageBanner = R.drawable.img_soccer
            ),
            Sport(
                id = 9,
                titleResourceId = R.string.swimming,
                subTitleResourceId = R.string.swimming_subtitle,
                imageResourceId = R.drawable.icon_swimming,
                sportsImageBanner = R.drawable.img_swimming
            ),
            Sport(
                id = 10,
                titleResourceId = R.string.table_tennis,
                subTitleResourceId = R.string.table_tennis_subtitle,
                imageResourceId = R.drawable.icon_tabletennis,
                sportsImageBanner = R.drawable.img_tabletennis
            ),
            Sport(
                id = 11,
                titleResourceId = R.string.tennis,
                subTitleResourceId = R.string.tennis_subtitle,
                imageResourceId = R.drawable.icon_tennis,
                sportsImageBanner = R.drawable.img_tennis
            )

        )
    }
}
