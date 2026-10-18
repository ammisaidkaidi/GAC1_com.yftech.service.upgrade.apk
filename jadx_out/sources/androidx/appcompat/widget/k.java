package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;

/* JADX INFO: loaded from: classes.dex */
@androidx.annotation.ap(a = {androidx.annotation.ap.a.LIBRARY_GROUP_PREFIX})
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f273a = "AppCompatDrawableManag";
    private static final boolean b = false;
    private static final PorterDuff.Mode c = PorterDuff.Mode.SRC_IN;
    private static k d;
    private ao e;

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        return ao.a(i, mode);
    }

    public static synchronized void a() {
        if (d == null) {
            d = new k();
            d.e = ao.a();
            d.e.a(new ao.e() { // from class: androidx.appcompat.widget.k.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                private final int[] f274a = {androidx.appcompat.a.f.abc_textfield_search_default_mtrl_alpha, androidx.appcompat.a.f.abc_textfield_default_mtrl_alpha, androidx.appcompat.a.f.abc_ab_share_pack_mtrl_alpha};
                private final int[] b = {androidx.appcompat.a.f.abc_ic_commit_search_api_mtrl_alpha, androidx.appcompat.a.f.abc_seekbar_tick_mark_material, androidx.appcompat.a.f.abc_ic_menu_share_mtrl_alpha, androidx.appcompat.a.f.abc_ic_menu_copy_mtrl_am_alpha, androidx.appcompat.a.f.abc_ic_menu_cut_mtrl_alpha, androidx.appcompat.a.f.abc_ic_menu_selectall_mtrl_alpha, androidx.appcompat.a.f.abc_ic_menu_paste_mtrl_am_alpha};
                private final int[] c = {androidx.appcompat.a.f.abc_textfield_activated_mtrl_alpha, androidx.appcompat.a.f.abc_textfield_search_activated_mtrl_alpha, androidx.appcompat.a.f.abc_cab_background_top_mtrl_alpha, androidx.appcompat.a.f.abc_text_cursor_material, androidx.appcompat.a.f.abc_text_select_handle_left_mtrl_dark, androidx.appcompat.a.f.abc_text_select_handle_middle_mtrl_dark, androidx.appcompat.a.f.abc_text_select_handle_right_mtrl_dark, androidx.appcompat.a.f.abc_text_select_handle_left_mtrl_light, androidx.appcompat.a.f.abc_text_select_handle_middle_mtrl_light, androidx.appcompat.a.f.abc_text_select_handle_right_mtrl_light};
                private final int[] d = {androidx.appcompat.a.f.abc_popup_background_mtrl_mult, androidx.appcompat.a.f.abc_cab_background_internal_bg, androidx.appcompat.a.f.abc_menu_hardkey_panel_mtrl_mult};
                private final int[] e = {androidx.appcompat.a.f.abc_tab_indicator_material, androidx.appcompat.a.f.abc_textfield_search_material};
                private final int[] f = {androidx.appcompat.a.f.abc_btn_check_material, androidx.appcompat.a.f.abc_btn_radio_material, androidx.appcompat.a.f.abc_btn_check_material_anim, androidx.appcompat.a.f.abc_btn_radio_material_anim};

                private ColorStateList a(@androidx.annotation.ah Context context) {
                    return b(context, av.a(context, androidx.appcompat.a.b.colorButtonNormal));
                }

                private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
                    if (af.c(drawable)) {
                        drawable = drawable.mutate();
                    }
                    if (mode == null) {
                        mode = k.c;
                    }
                    drawable.setColorFilter(k.a(i, mode));
                }

                private boolean a(int[] iArr, int i) {
                    for (int i2 : iArr) {
                        if (i2 == i) {
                            return true;
                        }
                    }
                    return false;
                }

                private ColorStateList b(@androidx.annotation.ah Context context) {
                    return b(context, 0);
                }

                private ColorStateList b(@androidx.annotation.ah Context context, @androidx.annotation.k int i) {
                    int iA = av.a(context, androidx.appcompat.a.b.colorControlHighlight);
                    return new ColorStateList(new int[][]{av.f238a, av.d, av.b, av.h}, new int[]{av.c(context, androidx.appcompat.a.b.colorButtonNormal), androidx.core.graphics.e.a(iA, i), androidx.core.graphics.e.a(iA, i), i});
                }

                private ColorStateList c(@androidx.annotation.ah Context context) {
                    return b(context, av.a(context, androidx.appcompat.a.b.colorAccent));
                }

                private ColorStateList d(Context context) {
                    int[][] iArr = new int[3][];
                    int[] iArr2 = new int[3];
                    ColorStateList colorStateListB = av.b(context, androidx.appcompat.a.b.colorSwitchThumbNormal);
                    if (colorStateListB == null || !colorStateListB.isStateful()) {
                        iArr[0] = av.f238a;
                        iArr2[0] = av.c(context, androidx.appcompat.a.b.colorSwitchThumbNormal);
                        iArr[1] = av.e;
                        iArr2[1] = av.a(context, androidx.appcompat.a.b.colorControlActivated);
                        iArr[2] = av.h;
                        iArr2[2] = av.a(context, androidx.appcompat.a.b.colorSwitchThumbNormal);
                    } else {
                        iArr[0] = av.f238a;
                        iArr2[0] = colorStateListB.getColorForState(iArr[0], 0);
                        iArr[1] = av.e;
                        iArr2[1] = av.a(context, androidx.appcompat.a.b.colorControlActivated);
                        iArr[2] = av.h;
                        iArr2[2] = colorStateListB.getDefaultColor();
                    }
                    return new ColorStateList(iArr, iArr2);
                }

                @Override // androidx.appcompat.widget.ao.e
                public ColorStateList a(@androidx.annotation.ah Context context, int i) {
                    if (i == androidx.appcompat.a.f.abc_edit_text_material) {
                        return androidx.appcompat.a.a.a.a(context, androidx.appcompat.a.d.abc_tint_edittext);
                    }
                    if (i == androidx.appcompat.a.f.abc_switch_track_mtrl_alpha) {
                        return androidx.appcompat.a.a.a.a(context, androidx.appcompat.a.d.abc_tint_switch_track);
                    }
                    if (i == androidx.appcompat.a.f.abc_switch_thumb_material) {
                        return d(context);
                    }
                    if (i == androidx.appcompat.a.f.abc_btn_default_mtrl_shape) {
                        return a(context);
                    }
                    if (i == androidx.appcompat.a.f.abc_btn_borderless_material) {
                        return b(context);
                    }
                    if (i == androidx.appcompat.a.f.abc_btn_colored_material) {
                        return c(context);
                    }
                    if (i == androidx.appcompat.a.f.abc_spinner_mtrl_am_alpha || i == androidx.appcompat.a.f.abc_spinner_textfield_background_material) {
                        return androidx.appcompat.a.a.a.a(context, androidx.appcompat.a.d.abc_tint_spinner);
                    }
                    if (a(this.b, i)) {
                        return av.b(context, androidx.appcompat.a.b.colorControlNormal);
                    }
                    if (a(this.e, i)) {
                        return androidx.appcompat.a.a.a.a(context, androidx.appcompat.a.d.abc_tint_default);
                    }
                    if (a(this.f, i)) {
                        return androidx.appcompat.a.a.a.a(context, androidx.appcompat.a.d.abc_tint_btn_checkable);
                    }
                    if (i == androidx.appcompat.a.f.abc_seekbar_thumb_material) {
                        return androidx.appcompat.a.a.a.a(context, androidx.appcompat.a.d.abc_tint_seek_thumb);
                    }
                    return null;
                }

                @Override // androidx.appcompat.widget.ao.e
                public PorterDuff.Mode a(int i) {
                    if (i == androidx.appcompat.a.f.abc_switch_thumb_material) {
                        return PorterDuff.Mode.MULTIPLY;
                    }
                    return null;
                }

                @Override // androidx.appcompat.widget.ao.e
                public Drawable a(@androidx.annotation.ah ao aoVar, @androidx.annotation.ah Context context, int i) {
                    if (i == androidx.appcompat.a.f.abc_cab_background_top_material) {
                        return new LayerDrawable(new Drawable[]{aoVar.a(context, androidx.appcompat.a.f.abc_cab_background_internal_bg), aoVar.a(context, androidx.appcompat.a.f.abc_cab_background_top_mtrl_alpha)});
                    }
                    return null;
                }

                @Override // androidx.appcompat.widget.ao.e
                public boolean a(@androidx.annotation.ah Context context, int i, @androidx.annotation.ah Drawable drawable) {
                    if (i == androidx.appcompat.a.f.abc_seekbar_track_material) {
                        LayerDrawable layerDrawable = (LayerDrawable) drawable;
                        a(layerDrawable.findDrawableByLayerId(R.id.background), av.a(context, androidx.appcompat.a.b.colorControlNormal), k.c);
                        a(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), av.a(context, androidx.appcompat.a.b.colorControlNormal), k.c);
                        a(layerDrawable.findDrawableByLayerId(R.id.progress), av.a(context, androidx.appcompat.a.b.colorControlActivated), k.c);
                        return true;
                    }
                    if (i != androidx.appcompat.a.f.abc_ratingbar_material && i != androidx.appcompat.a.f.abc_ratingbar_indicator_material && i != androidx.appcompat.a.f.abc_ratingbar_small_material) {
                        return false;
                    }
                    LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                    a(layerDrawable2.findDrawableByLayerId(R.id.background), av.c(context, androidx.appcompat.a.b.colorControlNormal), k.c);
                    a(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), av.a(context, androidx.appcompat.a.b.colorControlActivated), k.c);
                    a(layerDrawable2.findDrawableByLayerId(R.id.progress), av.a(context, androidx.appcompat.a.b.colorControlActivated), k.c);
                    return true;
                }

                /* JADX WARN: Code duplicated, block: B:21:0x0047  */
                /* JADX WARN: Code duplicated, block: B:23:0x004d  */
                /* JADX WARN: Code duplicated, block: B:26:0x005e  */
                /* JADX WARN: Code duplicated, block: B:28:0x0062 A[RETURN] */
                @Override // androidx.appcompat.widget.ao.e
                public boolean b(@androidx.annotation.ah Context context, int i, @androidx.annotation.ah Drawable drawable) {
                    int iRound;
                    boolean z;
                    PorterDuff.Mode mode = k.c;
                    boolean zA = a(this.f274a, i);
                    int i2 = R.attr.colorBackground;
                    if (zA) {
                        i2 = androidx.appcompat.a.b.colorControlNormal;
                    } else if (a(this.c, i)) {
                        i2 = androidx.appcompat.a.b.colorControlActivated;
                    } else {
                        if (!a(this.d, i)) {
                            if (i == androidx.appcompat.a.f.abc_list_divider_mtrl_alpha) {
                                i2 = R.attr.colorForeground;
                                iRound = Math.round(40.8f);
                                z = true;
                            } else if (i != androidx.appcompat.a.f.abc_dialog_material_background) {
                                iRound = -1;
                                z = false;
                                i2 = 0;
                            }
                            if (z) {
                                return false;
                            }
                            if (af.c(drawable)) {
                                drawable = drawable.mutate();
                            }
                            drawable.setColorFilter(k.a(av.a(context, i2), mode));
                            if (iRound != -1) {
                                drawable.setAlpha(iRound);
                            }
                            return true;
                        }
                        mode = PorterDuff.Mode.MULTIPLY;
                    }
                    iRound = -1;
                    z = true;
                    if (z) {
                        return false;
                    }
                    if (af.c(drawable)) {
                        drawable = drawable.mutate();
                    }
                    drawable.setColorFilter(k.a(av.a(context, i2), mode));
                    if (iRound != -1) {
                        drawable.setAlpha(iRound);
                    }
                    return true;
                }
            });
        }
    }

    static void a(Drawable drawable, ay ayVar, int[] iArr) {
        ao.a(drawable, ayVar, iArr);
    }

    public static synchronized k b() {
        if (d == null) {
            a();
        }
        return d;
    }

    public synchronized Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.q int i) {
        return this.e.a(context, i);
    }

    synchronized Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.q int i, boolean z) {
        return this.e.a(context, i, z);
    }

    synchronized Drawable a(@androidx.annotation.ah Context context, @androidx.annotation.ah bf bfVar, @androidx.annotation.q int i) {
        return this.e.a(context, bfVar, i);
    }

    public synchronized void a(@androidx.annotation.ah Context context) {
        this.e.a(context);
    }

    boolean a(@androidx.annotation.ah Context context, @androidx.annotation.q int i, @androidx.annotation.ah Drawable drawable) {
        return this.e.a(context, i, drawable);
    }

    synchronized ColorStateList b(@androidx.annotation.ah Context context, @androidx.annotation.q int i) {
        return this.e.b(context, i);
    }
}
