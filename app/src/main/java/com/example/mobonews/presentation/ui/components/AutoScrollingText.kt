import android.util.Log
import androidx.compose.animation.core.CubicBezierEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun AutoScroollingText(
    text: String,
    color: Color,
    style: TextStyle,
) {
    val scrollState = rememberScrollState()

    var shouldAnimate by remember {
        mutableStateOf(true)
    }
    LaunchedEffect(key1 = shouldAnimate) {
        Log.i("scroll", "textext: ${text.length}")
        scrollState.animateScrollTo(
            scrollState.maxValue,
            animationSpec = tween((text.length * 76),
                200,
                easing = CubicBezierEasing(0f, 0f, 0f, 0f))
        )
        scrollState.scrollTo(0)
        shouldAnimate = !shouldAnimate
    }
    Text(
        modifier = Modifier
            .horizontalScroll(scrollState, false)
            .fillMaxWidth(),
        text = text,
        color = color,
        style = style,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1,
    )
}