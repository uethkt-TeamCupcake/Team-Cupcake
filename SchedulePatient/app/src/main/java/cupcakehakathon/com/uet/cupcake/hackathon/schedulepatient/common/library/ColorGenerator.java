package cupcakehakathon.com.uet.cupcake.hackathon.schedulepatient.common.library;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by Luong Tran on 3/11/2017.
 */

public class ColorGenerator {

    public static ColorGenerator DEFAULT;

    public static ColorGenerator MATERIAL;

    static {
        DEFAULT = create(Arrays.asList(0xfff16364,
                                       0xfff58559,
                                       0xfff9a43e,
                                       0xffe4c62e,
                                       0xff67bf74,
                                       0xff59a2be,
                                       0xff2093cd,
                                       0xffad62a7,
                                       0xff805781));
        MATERIAL = create(Arrays.asList(0xffe57373,
                                        0xfff06292,
                                        0xffba68c8,
                                        0xff9575cd,
                                        0xff7986cb,
                                        0xff64b5f6,
                                        0xff4fc3f7,
                                        0xff4dd0e1,
                                        0xff4db6ac,
                                        0xff81c784,
                                        0xffaed581,
                                        0xffff8a65,
                                        0xffd4e157,
                                        0xffffd54f,
                                        0xffffb74d,
                                        0xffa1887f,
                                        0xff90a4ae));
    }

    public static ColorGenerator MATERIAL_COLOR = create(Arrays.asList(colorMaterial.Red_700,
                                                                       colorMaterial.Pink_700,
                                                                       colorMaterial.Purple_700,
                                                                       colorMaterial.Deep_Purple_700,
                                                                       colorMaterial.Indigo_700,
                                                                       colorMaterial.Blue_700,
                                                                       colorMaterial.Green_700,
                                                                       colorMaterial.Light_Blue_700,
                                                                       colorMaterial.Cyan_700,
                                                                       colorMaterial.Teal_700,
                                                                       colorMaterial.Light_Green_700,
                                                                       colorMaterial.Lime_700,
                                                                       colorMaterial.Yellow_700,
                                                                       colorMaterial.Amber_700,
                                                                       colorMaterial.Brown_700,
                                                                       colorMaterial.Orange_700,
                                                                       colorMaterial.Deep_Orange_700,
                                                                       colorMaterial.Grey_700));

    private final List<Integer> mColors;
    private final Random mRandom;

    public static ColorGenerator create(List<Integer> colorList) {
        return new ColorGenerator(colorList);
    }

    private ColorGenerator(List<Integer> colorList) {
        mColors = colorList;
        mRandom = new Random(System.currentTimeMillis());
    }

    public int getRandomColor() {
        return mColors.get(mRandom.nextInt(mColors.size()));
    }

    public int getColor(Object key) {
        return mColors.get(Math.abs(key.hashCode()) % mColors.size());
    }

    public class colorMaterial {

        static final int Red_50 = 0xFFFFEBEE;
        static final int Red_100 = 0xFFFFCDD2;
        static final int Red_200 = 0xFFEF9A9A;
        static final int Red_300 = 0xFFE57373;
        static final int Red_400 = 0xFFEF5350;
        static final int Red_500 = 0xFFF44336;
        static final int Red_600 = 0xFFE53935;
        static final int Red_700 = 0xFFD32F2F;
        static final int Red_800 = 0xFFC62828;
        static final int Red_900 = 0xFFB71C1C;
        static final int Red_A100 = 0xFFFF8A80;
        static final int Red_A200 = 0xFFFF5252;
        static final int Red_A400 = 0xFFFF1744;
        static final int Red_A700 = 0xFFD50000;

        static final int Pink_50 = 0xFFFCE4EC;
        static final int Pink_100 = 0xFFF8BBD0;
        static final int Pink_200 = 0xFFF48FB1;
        static final int Pink_300 = 0xFFF06292;
        static final int Pink_400 = 0xFFEC407A;
        static final int Pink_500 = 0xFFE91E63;
        static final int Pink_600 = 0xFFD81B60;
        static final int Pink_700 = 0xFFC2185B;
        static final int Pink_800 = 0xFFAD1457;
        static final int Pink_900 = 0xFF880E4F;
        static final int Pink_A100 = 0xFFFF80AB;
        static final int Pink_A200 = 0xFFFF4081;
        static final int Pink_A400 = 0xFFF50057;
        static final int Pink_A700 = 0xFFC51162;

        static final int Purple_50 = 0xFFF3E5F5;
        static final int Purple_100 = 0xFFE1BEE7;
        static final int Purple_200 = 0xFFCE93D8;
        static final int Purple_300 = 0xFFBA68C8;
        static final int Purple_400 = 0xFFAB47BC;
        static final int Purple_500 = 0xFF9C27B0;
        static final int Purple_600 = 0xFF8E24AA;
        static final int Purple_700 = 0xFF7B1FA2;
        static final int Purple_800 = 0xFF6A1B9A;
        static final int Purple_900 = 0xFF4A148C;
        static final int Purple_A100 = 0xFFEA80FC;
        static final int Purple_A200 = 0xFFE040FB;
        static final int Purple_A400 = 0xFFD500F9;
        static final int Purple_A700 = 0xFFAA00FF;

        static final int Deep_Purple_50 = 0xFFEDE7F6;
        static final int Deep_Purple_100 = 0xFFD1C4E9;
        static final int Deep_Purple_200 = 0xFFB39DDB;
        static final int Deep_Purple_300 = 0xFF9575CD;
        static final int Deep_Purple_400 = 0xFF7E57C2;
        static final int Deep_Purple_500 = 0xFF673AB7;
        static final int Deep_Purple_600 = 0xFF5E35B1;
        static final int Deep_Purple_700 = 0xFF512DA8;
        static final int Deep_Purple_800 = 0xFF4527A0;
        static final int Deep_Purple_900 = 0xFF311B92;
        static final int Deep_Purple_A100 = 0xFFB388FF;
        static final int Deep_Purple_A200 = 0xFF7C4DFF;
        static final int Deep_Purple_A400 = 0xFF651FFF;
        static final int Deep_Purple_A700 = 0xFF6200EA;

        static final int Indigo_50 = 0xFFE8EAF6;
        static final int Indigo_100 = 0xFFC5CAE9;
        static final int Indigo_200 = 0xFF9FA8DA;
        static final int Indigo_300 = 0xFF7986CB;
        static final int Indigo_400 = 0xFF5C6BC0;
        static final int Indigo_500 = 0xFF3F51B5;
        static final int Indigo_600 = 0xFF3949AB;
        static final int Indigo_700 = 0xFF303F9F;
        static final int Indigo_800 = 0xFF283593;
        static final int Indigo_900 = 0xFF1A237E;
        static final int Indigo_A100 = 0xFF8C9EFF;
        static final int Indigo_A200 = 0xFF536DFE;
        static final int Indigo_A400 = 0xFF3D5AFE;
        static final int Indigo_A700 = 0xFF304FFE;

        static final int Blue_50 = 0xFFE3F2FD;
        static final int Blue_100 = 0xFFBBDEFB;
        static final int Blue_200 = 0xFF90CAF9;
        static final int Blue_300 = 0xFF64B5F6;
        static final int Blue_400 = 0xFF42A5F5;
        static final int Blue_500 = 0xFF2196F3;
        static final int Blue_600 = 0xFF1E88E5;
        static final int Blue_700 = 0xFF1976D2;
        static final int Blue_800 = 0xFF1565C0;
        static final int Blue_900 = 0xFF0D47A1;
        static final int Blue_A100 = 0xFF82B1FF;
        static final int Blue_A200 = 0xFF448AFF;
        static final int Blue_A400 = 0xFF2979FF;
        static final int Blue_A700 = 0xFF2962FF;

        static final int Light_Blue_50 = 0xFFE1F5FE;
        static final int Light_Blue_100 = 0xFFB3E5FC;
        static final int Light_Blue_200 = 0xFF81D4FA;
        static final int Light_Blue_300 = 0xFF4FC3F7;
        static final int Light_Blue_400 = 0xFF29B6F6;
        static final int Light_Blue_500 = 0xFF03A9F4;
        static final int Light_Blue_600 = 0xFF039BE5;
        static final int Light_Blue_700 = 0xFF0288D1;
        static final int Light_Blue_800 = 0xFF0277BD;
        static final int Light_Blue_900 = 0xFF01579B;
        static final int Light_Blue_A100 = 0xFF80D8FF;
        static final int Light_Blue_A200 = 0xFF40C4FF;
        static final int Light_Blue_A400 = 0xFF00B0FF;
        static final int Light_Blue_A700 = 0xFF0091EA;

        static final int Cyan_50 = 0xFFE0F7FA;
        static final int Cyan_100 = 0xFFB2EBF2;
        static final int Cyan_200 = 0xFF80DEEA;
        static final int Cyan_300 = 0xFF4DD0E1;
        static final int Cyan_400 = 0xFF26C6DA;
        static final int Cyan_500 = 0xFF00BCD4;
        static final int Cyan_600 = 0xFF00ACC1;
        static final int Cyan_700 = 0xFF0097A7;
        static final int Cyan_800 = 0xFF00838F;
        static final int Cyan_900 = 0xFF006064;
        static final int Cyan_A100 = 0xFF84FFFF;
        static final int Cyan_A200 = 0xFF18FFFF;
        static final int Cyan_A400 = 0xFF00E5FF;
        static final int Cyan_A700 = 0xFF00B8D4;

        static final int Teal_50 = 0xFFE0F2F1;
        static final int Teal_100 = 0xFFB2DFDB;
        static final int Teal_200 = 0xFF80CBC4;
        static final int Teal_300 = 0xFF4DB6AC;
        static final int Teal_400 = 0xFF26A69A;
        static final int Teal_500 = 0xFF009688;
        static final int Teal_600 = 0xFF00897B;
        static final int Teal_700 = 0xFF00796B;
        static final int Teal_800 = 0xFF00695C;
        static final int Teal_900 = 0xFF004D40;
        static final int Teal_A100 = 0xFFA7FFEB;
        static final int Teal_A200 = 0xFF64FFDA;
        static final int Teal_A400 = 0xFF1DE9B6;
        static final int Teal_A700 = 0xFF00BFA5;

        static final int Green_50 = 0xFFE8F5E9;
        static final int Green_100 = 0xFFC8E6C9;
        static final int Green_200 = 0xFFA5D6A7;
        static final int Green_300 = 0xFF81C784;
        static final int Green_400 = 0xFF66BB6A;
        static final int Green_500 = 0xFF4CAF50;
        static final int Green_600 = 0xFF43A047;
        static final int Green_700 = 0xFF388E3C;
        static final int Green_800 = 0xFF2E7D32;
        static final int Green_900 = 0xFF1B5E20;
        static final int Green_A100 = 0xFFB9F6CA;
        static final int Green_A200 = 0xFF69F0AE;
        static final int Green_A400 = 0xFF00E676;
        static final int Green_A700 = 0xFF00C853;

        static final int Light_Green_50 = 0xFFF1F8E9;
        static final int Light_Green_100 = 0xFFDCEDC8;
        static final int Light_Green_200 = 0xFFC5E1A5;
        static final int Light_Green_300 = 0xFFAED581;
        static final int Light_Green_400 = 0xFF9CCC65;
        static final int Light_Green_500 = 0xFF8BC34A;
        static final int Light_Green_600 = 0xFF7CB342;
        static final int Light_Green_700 = 0xFF689F38;
        static final int Light_Green_800 = 0xFF558B2F;
        static final int Light_Green_900 = 0xFF33691E;
        static final int Light_Green_A100 = 0xFFCCFF90;
        static final int Light_Green_A200 = 0xFFB2FF59;
        static final int Light_Green_A400 = 0xFF76FF03;
        static final int Light_Green_A700 = 0xFF64DD17;

        static final int Lime_50 = 0xFFF9FBE7;
        static final int Lime_100 = 0xFFF0F4C3;
        static final int Lime_200 = 0xFFE6EE9C;
        static final int Lime_300 = 0xFFDCE775;
        static final int Lime_400 = 0xFFD4E157;
        static final int Lime_500 = 0xFFCDDC39;
        static final int Lime_600 = 0xFFC0CA33;
        static final int Lime_700 = 0xFFAFB42B;
        static final int Lime_800 = 0xFF9E9D24;
        static final int Lime_900 = 0xFF827717;
        static final int Lime_A100 = 0xFFF4FF81;
        static final int Lime_A200 = 0xFFEEFF41;
        static final int Lime_A400 = 0xFFC6FF00;
        static final int Lime_A700 = 0xFFAEEA00;

        static final int Yellow_50 = 0xFFFFFDE7;
        static final int Yellow_100 = 0xFFFFF9C4;
        static final int Yellow_200 = 0xFFFFF59D;
        static final int Yellow_300 = 0xFFFFF176;
        static final int Yellow_400 = 0xFFFFEE58;
        static final int Yellow_500 = 0xFFFFEB3B;
        static final int Yellow_600 = 0xFFFDD835;
        static final int Yellow_700 = 0xFFFBC02D;
        static final int Yellow_800 = 0xFFF9A825;
        static final int Yellow_900 = 0xFFF57F17;
        static final int Yellow_A100 = 0xFFFFFF8D;
        static final int Yellow_A200 = 0xFFFFFF00;
        static final int Yellow_A400 = 0xFFFFEA00;
        static final int Yellow_A700 = 0xFFFFD600;

        static final int Amber_50 = 0xFFFFF8E1;
        static final int Amber_100 = 0xFFFFECB3;
        static final int Amber_200 = 0xFFFFE082;
        static final int Amber_300 = 0xFFFFD54F;
        static final int Amber_400 = 0xFFFFCA28;
        static final int Amber_500 = 0xFFFFC107;
        static final int Amber_600 = 0xFFFFB300;
        static final int Amber_700 = 0xFFFFA000;
        static final int Amber_800 = 0xFFFF8F00;
        static final int Amber_900 = 0xFFFF6F00;
        static final int Amber_A100 = 0xFFFFE57F;
        static final int Amber_A200 = 0xFFFFD740;
        static final int Amber_A400 = 0xFFFFC400;
        static final int Amber_A700 = 0xFFFFAB00;

        static final int Orange_50 = 0xFFFFF3E0;
        static final int Orange_100 = 0xFFFFE0B2;
        static final int Orange_200 = 0xFFFFCC80;
        static final int Orange_300 = 0xFFFFB74D;
        static final int Orange_400 = 0xFFFFA726;
        static final int Orange_500 = 0xFFFF9800;
        static final int Orange_600 = 0xFFFB8C00;
        static final int Orange_700 = 0xFFF57C00;
        static final int Orange_800 = 0xFFEF6C00;
        static final int Orange_900 = 0xFFE65100;
        static final int Orange_A100 = 0xFFFFD180;
        static final int Orange_A200 = 0xFFFFAB40;
        static final int Orange_A400 = 0xFFFF9100;
        static final int Orange_A700 = 0xFFFF6D00;

        static final int Deep_Orange_50 = 0xFFFBE9E7;
        static final int Deep_Orange_100 = 0xFFFFCCBC;
        static final int Deep_Orange_200 = 0xFFFFAB91;
        static final int Deep_Orange_300 = 0xFFFF8A65;
        static final int Deep_Orange_400 = 0xFFFF7043;
        static final int Deep_Orange_500 = 0xFFFF5722;
        static final int Deep_Orange_600 = 0xFFF4511E;
        static final int Deep_Orange_700 = 0xFFE64A19;
        static final int Deep_Orange_800 = 0xFFD84315;
        static final int Deep_Orange_900 = 0xFFBF360C;
        static final int Deep_Orange_A100 = 0xFFFF9E80;
        static final int Deep_Orange_A200 = 0xFFFF6E40;
        static final int Deep_Orange_A400 = 0xFFFF3D00;
        static final int Deep_Orange_A700 = 0xFFDD2C00;

        static final int Brown_50 = 0xFFEFEBE9;
        static final int Brown_100 = 0xFFD7CCC8;
        static final int Brown_200 = 0xFFBCAAA4;
        static final int Brown_300 = 0xFFA1887F;
        static final int Brown_400 = 0xFF8D6E63;
        static final int Brown_500 = 0xFF795548;
        static final int Brown_600 = 0xFF6D4C41;
        static final int Brown_700 = 0xFF5D4037;
        static final int Brown_800 = 0xFF4E342E;
        static final int Brown_900 = 0xFF3E2723;

        static final int Grey_50 = 0xFFFAFAFA;
        static final int Grey_100 = 0xFFF5F5F5;
        static final int Grey_200 = 0xFFEEEEEE;
        static final int Grey_300 = 0xFFE0E0E0;
        static final int Grey_400 = 0xFFBDBDBD;
        static final int Grey_500 = 0xFF9E9E9E;
        static final int Grey_600 = 0xFF757575;
        static final int Grey_700 = 0xFF616161;
        static final int Grey_800 = 0xFF424242;
        static final int Grey_900 = 0xFF212121;

        static final int Blue_Grey_50 = 0xFFECEFF1;
        static final int Blue_Grey_100 = 0xFFCFD8DC;
        static final int Blue_Grey_200 = 0xFFB0BEC5;
        static final int Blue_Grey_300 = 0xFF90A4AE;
        static final int Blue_Grey_400 = 0xFF78909C;
        static final int Blue_Grey_500 = 0xFF607D8B;
        static final int Blue_Grey_600 = 0xFF546E7A;
        static final int Blue_Grey_700 = 0xFF455A64;
        static final int Blue_Grey_800 = 0xFF37474F;
        static final int Blue_Grey_900 = 0xFF263238;

        static final int Black = 0xFF000000;
        static final int White = 0xFFFFFFFF;
    }
}