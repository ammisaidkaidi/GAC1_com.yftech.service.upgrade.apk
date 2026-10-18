package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: loaded from: classes.dex */
final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @androidx.annotation.ah
    private TextView f296a;

    @androidx.annotation.ai
    private TextClassifier b;

    y(@androidx.annotation.ah TextView textView) {
        this.f296a = (TextView) androidx.core.m.i.a(textView);
    }

    @androidx.annotation.am(b = 26)
    @androidx.annotation.ah
    public TextClassifier a() {
        if (this.b != null) {
            return this.b;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f296a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    @androidx.annotation.am(b = 26)
    public void a(@androidx.annotation.ai TextClassifier textClassifier) {
        this.b = textClassifier;
    }
}
