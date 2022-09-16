package com.example.mobonews.presentation.ui.newsDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.mobonews.R
import com.example.mobonews.presentation.ui.components.Chips
import com.example.mobonews.presentation.ui.components.PublisherChips
import com.example.mobonews.presentation.ui.components.alphaAnimation
import com.example.mobonews.presentation.ui.components.offsetXAnimation


@Composable
fun NewsDetail() {

}


@Composable
private fun Content() {
    Box(modifier = Modifier.fillMaxSize().background(color = MaterialTheme.colors.background)) {

        Image(
            modifier = Modifier.fillMaxWidth().height(300.dp)
                .alphaAnimation(delay = 500, 800),
            painter = rememberAsyncImagePainter(model = "https://digimoplus.ir/mobonews/title_image.jpg"),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        Column(
            modifier = Modifier.fillMaxSize()
                .verticalScroll(rememberScrollState()),
        ) {
            Spacer(modifier = Modifier.padding(top = 270.dp))
            Card(
                modifier = Modifier.fillMaxWidth()
                    .offsetXAnimation(
                        delay = 0,
                        duration = 500,
                        startOffset = 400.dp,
                        endOffset = 0.dp,
                    ),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                backgroundColor = MaterialTheme.colors.surface,
            ) {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Spacer(modifier = Modifier.padding(top = 12.dp))
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                    ) {
                        Row(
                            modifier = Modifier.align(Alignment.CenterStart),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Image(
                                modifier = Modifier.size(18.dp),
                                painter = painterResource(R.drawable.ic_flash),
                                contentDescription = null,
                            )
                            Spacer(modifier = Modifier.padding(end = 8.dp))
                            Text(
                                text = "پیشنهاد مونیوز",
                                color = MaterialTheme.colors.secondary,
                                style = MaterialTheme.typography.h5,
                            )
                        }
                        PublisherChips(
                            modifier = Modifier.align(Alignment.Center),
                            title = "خبر گذاری آخرین خبر",
                            imageUrl = "https://digimoplus.ir/mobonews/publisher_hot_news_1.png",
                        )
                        Text(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            text = "۵ دقیقه قبل",
                            color = MaterialTheme.colors.secondary,
                            style = MaterialTheme.typography.h5,
                        )
                    }
                    Spacer(modifier = Modifier.padding(top = 16.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "پاسـخ مـنـفی پــورتـو به چـلـسی بـرای جــذب طـارمـی با طعم تهدید!",
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.h1,
                    )
                    Spacer(modifier = Modifier.padding(top = 12.dp))
                    LazyRow(modifier = Modifier.fillMaxWidth()) {
                        items(count = 3) {
                            Chips(
                                modifier = Modifier.padding(end = 12.dp),
                                title = "ورزشی",
                                textColor = MaterialTheme.colors.primary,
                                backgroundColor = MaterialTheme.colors.onPrimary,
                            )
                        }
                    }
                    Spacer(modifier = Modifier.padding(top = 12.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "باشگاه چلسی که پیگیر جذب مهدی طارمی مهاجـم ایران بـود، با پاسـخ منفی باشگاه پورتو مواجه شد و این بازیـکن باوجود رویای بازی در لیگ برتر انگلیس فعلا در پرتغال ماندنی است.",
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.h3,
                        lineHeight = 23.sp,
                    )
                    Spacer(modifier = Modifier.padding(top = 12.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "بحث پیشنهاد باشگاه چلسـی انـگـلیس به پـورتـو بـرای جـذب مـهدی\n" +
                                "طــارمـی در آخـریــن ســاعــات نــقـل و انـتـقـالـات فــوتـبـال اروپـا یــکـی از\n" +
                                "سوژه\u200Cهای اصلی هواداران دو تیم بود. این خبر در حالی رسانه\u200Cای شد\n" +
                                "که گفته می\u200Cشد چلسی برای جذب طارمی مبلغ ۲۵ میلیون یورو را به\n" +
                                "پورتو پیشنهاد داده است.\n" +
                                "روزنـامه «ابولا» پرتغال هم روز چهارشنـبـه ایــن خـبر را اعلـام کرد و به\n" +
                                "دنبال آن بعضی از مطبوعات انگلیس و کشورهای دیگر هم پیشنهاد\n" +
                                "چلسی به طارمی را دنبال کردند.\n" +
                                "بحث پیشنهاد باشگاه چلسـی انـگـلیس به پـورتـو بـرای جـذب مـهدی\n" +
                                "طــارمـی در آخـریــن ســاعــات نــقـل و انـتـقـالـات فــوتـبـال اروپـا یــکـی از\n" +
                                "سوژه\u200Cهای اصلی هواداران دو تیم بود. این خبر در حالی رسانه\u200Cای شد\n" +
                                "که گفته می\u200Cشد چلسی برای جذب طارمی مبلغ ۲۵ میلیون یورو را به\n" +
                                "پورتو پیشنهاد داده است.\n" +
                                "روزنـامه «ابولا» پرتغال هم روز چهارشنـبـه ایــن خـبر را اعلـام کرد و به\n" +
                                "دنبال آن بعضی از مطبوعات انگلیس و کشورهای دیگر هم پیشنهاد\n" +
                                "چلسی به طارمی را دنبال کردند.\n" +
                                "بحث پیشنهاد باشگاه چلسـی انـگـلیس به پـورتـو بـرای جـذب مـهدی\n" +
                                "طــارمـی در آخـریــن ســاعــات نــقـل و انـتـقـالـات فــوتـبـال اروپـا یــکـی از\n" +
                                "سوژه\u200Cهای اصلی هواداران دو تیم بود. این خبر در حالی رسانه\u200Cای شد\n" +
                                "که گفته می\u200Cشد چلسی برای جذب طارمی مبلغ ۲۵ میلیون یورو را به\n" +
                                "پورتو پیشنهاد داده است.\n" +
                                "روزنـامه «ابولا» پرتغال هم روز چهارشنـبـه ایــن خـبر را اعلـام کرد و به\n" +
                                "دنبال آن بعضی از مطبوعات انگلیس و کشورهای دیگر هم پیشنهاد\n" +
                                "چلسی به طارمی را دنبال کردند.\n" +
                                "بحث پیشنهاد باشگاه چلسـی انـگـلیس به پـورتـو بـرای جـذب مـهدی\n" +
                                "طــارمـی در آخـریــن ســاعــات نــقـل و انـتـقـالـات فــوتـبـال اروپـا یــکـی از\n" +
                                "سوژه\u200Cهای اصلی هواداران دو تیم بود. این خبر در حالی رسانه\u200Cای شد\n" +
                                "که گفته می\u200Cشد چلسی برای جذب طارمی مبلغ ۲۵ میلیون یورو را به\n" +
                                "پورتو پیشنهاد داده است.\n" +
                                "روزنـامه «ابولا» پرتغال هم روز چهارشنـبـه ایــن خـبر را اعلـام کرد و به\n" +
                                "دنبال آن بعضی از مطبوعات انگلیس و کشورهای دیگر هم پیشنهاد\n" +
                                "چلسی به طارمی را دنبال کردند.\n",
                        color = MaterialTheme.colors.primaryVariant,
                        style = MaterialTheme.typography.body2,
                        lineHeight = 23.sp,
                    )
                }
            }

        }

    }
}