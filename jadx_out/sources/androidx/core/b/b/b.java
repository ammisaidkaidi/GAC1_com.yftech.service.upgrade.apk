package androidx.core.b.b;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ah;
import androidx.annotation.ai;
import androidx.annotation.ap;
import androidx.annotation.k;
import androidx.annotation.m;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
@ap(a = {ap.a.LIBRARY_GROUP_PREFIX})
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f398a = "ComplexColorCompat";
    private final Shader b;
    private final ColorStateList c;
    private int d;

    private b(Shader shader, ColorStateList colorStateList, @k int i) {
        this.b = shader;
        this.c = colorStateList;
        this.d = i;
    }

    static b a(@k int i) {
        return new b(null, null, i);
    }

    static b a(@ah ColorStateList colorStateList) {
        return new b(null, colorStateList, colorStateList.getDefaultColor());
    }

    @ai
    public static b a(@ah Resources resources, @m int i, @ai Resources.Theme theme) {
        try {
            return b(resources, i, theme);
        } catch (Exception e) {
            Log.e(f398a, "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    static b a(@ah Shader shader) {
        return new b(shader, null, 0);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    @ah
    private static b b(@ah Resources resources, @m int i, @ai Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        XmlResourceParser xml = resources.getXml(i);
        AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
        do {
            next = xml.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        switch (name) {
            case "selector":
                return a(a.a(resources, xml, attributeSetAsAttributeSet, theme));
            case "gradient":
                return a(e.a(resources, xml, attributeSetAsAttributeSet, theme));
            default:
                throw new XmlPullParserException(xml.getPositionDescription() + ": unsupported complex color tag " + name);
        }
    }

    @ai
    public Shader a() {
        return this.b;
    }

    public boolean a(int[] iArr) {
        int colorForState;
        if (!d() || (colorForState = this.c.getColorForState(iArr, this.c.getDefaultColor())) == this.d) {
            return false;
        }
        this.d = colorForState;
        return true;
    }

    @k
    public int b() {
        return this.d;
    }

    public void b(@k int i) {
        this.d = i;
    }

    public boolean c() {
        return this.b != null;
    }

    public boolean d() {
        return this.b == null && this.c != null && this.c.isStateful();
    }

    public boolean e() {
        return c() || this.d != 0;
    }
}
