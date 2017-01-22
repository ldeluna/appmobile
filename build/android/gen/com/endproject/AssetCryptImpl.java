package com.endproject;

import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.nio.CharBuffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.lang.reflect.Method;
import java.lang.System;
import org.appcelerator.kroll.util.KrollAssetHelper;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.titanium.TiApplication;
import android.os.Debug;


public class AssetCryptImpl implements KrollAssetHelper.AssetCrypt
{

	private static class Range {
		int offset;
		int length;
		public Range(int offset, int length) {
			this.offset = offset;
			this.length = length;
		}
	}

		private static final byte[] assetsBytes = Charset.forName("ISO-8859-1").encode(initAssetsBytes()).array();
	private static CharBuffer initAssetsBytes() {
		CharBuffer buffer = CharBuffer.allocate(7399);
		buffer.append("\237\342\310'A\267\024c\021\034r\213\343w\216\343\342f?\230TCL\337n\005`1lOE\275\316\364r\356>\361\351*\203~B\373\022L\027\026\212\243\366\206\240\274\017\321(#\344@M\322\3719>\000*y\332\313X\267\366\227|:\240\354\004d\012Y5\304n\011\236\374\272\217\330\335\366\205G\275\200i[-?\273\354\017d\231\013\220\212\322WS\310\036\271\325\274\224\276\354\204\273\317p\360\261\270.x&\376\353\224\266\236\374\034\333\017\032\370\352q=\225'\311\375\337\256f\027Q\024\205\343>\015l\301m&8L_\220r\345d\"*\276\234\336\306\027p+\260\200n\032\334\266\312\234\2435\0366b\201\024h\301\304\217=\351e\266\200yX\256i\234s%\327\300p\206\316\325\333L%E\300\200(\261\276\243\222P>\251\341\303\324-\350\344}IUm\275L\362\204{\202\322\377\0179\316\233I_\021\372GxI\015\341\340\365\3250\035\213\274\002k\013\316\315\024o\335[o\263\240\365\224\035\"7\342\223\010(0\003\244\224\265_!\221\343G\331`\3032\345z]\013\012\220o\374w\240\352,\252\023\344\307\367E\340Pq\302k\314h\210CS]\362'al\332\015\331\202L\032'\230\375\256]N=\363\304\255\3620\330B\224=KFb\201\322\240\"\253\320\314\275a'\037@^uJ\024!L\257\014\272\206\370j\370\236\023z\204\313\257(\233\365\030\207\3065\337^\237\263g\263L[\247o\332\336\354\307\362+\272.j*\306\224\245;\010\370\375\215\375-\342\014\257\302\262\320\237\264LD\025\317\321@w\337D\321\231\332MR\274\247nZ\331Yl\021O\363\212\031\365n\237o\337\312\210\343>\262j\344\214\237@\244|\261\010\257-:\241\275\376P\027\365*\2618\347\316\3022r\035R\326\035^~d\217<\377\275\036\310\271\223>\350|\0140\027e\032\324m\033x{\011t\015\347\305_Me\232\024\335N-d\201\256\214\345\377\366T\243\216\222\260\003\244r\203\343)\030\035I\264wUl=\341k\215\347\241(\203\205\267\223\355\346\243\035\326I\233~=\235\262\251\004\357\346\361\320\333\262\225\013\004\347B\206\007W\237\346\005J\305\036\204\321\342\\\255\265lmR\250\276\340\254Q\275q\225\227r\364\031<4\2135r\235+7\315\353\261x\276\375G\371\322\266\261\2259\326G$\322\210e\201\210\240\372\373U\363\272\314\207oC\224\006=\014;\277\351\201zX\016\351\335\240\316wW\352\367(\036\2658\361-d\277\0032\334\204`=\022\264\321\224\312\330Pv\\ \351\310\262\221\325\306\340R\223\3503\302\356\034j\377\251[h\" S\354V\002u\004\347erWF\315n\241<\275\010:\212\012#E`\002\261k\241~M\371h`\324N\224X\324ek\241T\037JFM\357\206\013t\341\214|\242\251]k\205\343\203\236o,\003d\344\010K*\324\300&N=\345\222\002\347\364?\251UQ\001\014\011D\203IS|\004\012v\026\246\306\024\256Y;M\251`\031\367#\015\345\310\305h;\327\030\302\003g\326`\304i\271<%YKU\205\302Z\217\334;~j\031\242C\263\330x\224\353)\364U\235\376\005b\000\223\230\032\016\272i\362TA;\244\304\277O\260\2622\333\000\310\273\351^p\217\326\350\221P\253b2\336\022\257\177\267\327\354\302\351\\\014;&>r~O)\352\325\243\200\034\246\027\201(E\312\340\256^E\2171\247j\030\\4\333\351\266\322\316\307\270\224\364\267\305\217ur\256\0312\022laH\323?5\345\204\024\257b+@\235.!\227\265\237L\3278z \367\216\006\245)y\261`\247\230\027\200\231@\244 D\370\334\310\020Q[\031\252\210\214\310\354\224\272\212\375\035u}!\016\015\011\277\256\354^J\240\332Y\273c\021q\230\352'bu:\023\242A[\215E\235\325d\015\255\037\337\0068$K\011(mg\362\233l\356\275\223\006\2105\217\274\323}\271\2557\020\035w\3677*\230\317\014m\013\305;/(\322\3651\314@\315\315\367OQ\213'u4\274\245i\341\005\021!V%\374\355\000\243\024va\2240}&\360\337\260\216AH\324\274S\3164\346\320\304\305\033\237\367\262W~\212\361\203O\021D[\352\030\224\246\302\253yJ5\344\233/\262=pa\023\014\261\005\305\266n\"\365\211\310Y\306\003~\226E\214n\250\213\014J\265\256\200?\203\337?\231&2\036\3769]\332\350\026\036>\276Dm8\271\372;z19\3234QF\346m\006\254n\224\267\265\232S\274\265c\252\012{)!\257\344\363\317N|D\222N\021\205.[\032Na\230P\0310\335Y\005\233\372\205\203O\006\30122\313B9\316\301K\262\014/\007\371\022\222\374}b\377\310o\252\221\276\034\363r\354^\266M4\351\307\306\303f\340\222\013\233\221\207\276f\337\006\254\276\0004\373\315\242(\325t\316\326\256\255[\236\327\270\355%A-\357\3248\017\247F\360@Tbb\017\010\237\\Fl\002V\205\372&\323R\374\3768\242\2218+t\315oW\032h\373m\250\343\3401Ru\221Q4\025\224\346\243\035\326I\233~=\235\262\251\004\357\346\361\320\273\030\361\236_s\325~\362\327@\356dD!$\200gljUi?\013\3339M\352%8\314@\316\222\263e?\325?\275v\313\036\256\237\025\205\370g\257|\016`\013\240\226\3734x\335W\260z\363\230f\302\341\035D\234*\326s\017?\203v\341v\274yc#\2576\304\324\003\254\006\021\221\247\033\352\0061U\033k\221\303\357#\033LA8\3200F\246<\3239\331\177+l\345\006\005\210>M\377Z\257\210m\007\036;reP\360l7\314\270\312\343s\205\3078\255v\344@\262\370\021\242\253!\342\026+\222\011gV\301S!z\007\236\027=\304\226e\315\371\250~\301L\006\224\265Q\363\233K\\{\243\362\326C\251\305A\257\315=\013\334\251\276\373\022U)\017\200c\202^\376\273.m\233Eb\334\017\331\016\357\331h\312I\332dM\220\001\024B\301\362Y\244\021.\313\345\273:4~t\337bk]\200\325\012bc\245\223\012\270\243\211\007\274}\"r\353\271\276]\354!\267\250\213_\344\266\327'%\302M\023\006\010\373\367\274\022\257u\214/~9\376: \363\371e\255\304e4&-\353\016\305\212;Eb\343Z\276\342K\312\355@\234\341\345+\315M\221\322\311U\320`D\303\321\250256\230\274l\203\016\201\327GPQ4 \222\340\202#\202\3274\257\314\274\330\245\304 \324\010{\312\334\246\237\215v\267?y\232\317'z\373\271\037\226,H\357\244\3712\371\200\023b\221>\373'\272\220z3\242\324\326\350\370J\315\000h\011J\375K\233:\264\003\356F\334\326\021\345\310\242\367VM\017\027\002\2748\207\344w\351=\243\260\034]b+\220'\211\360{W\016\367\027%O\334f}Bx\336w\252\276\222\321\017\276;\003\377Z\026kz\345\374\021\033\230\372\027\312[Y\237\340\363`S\272\325j88\236#\240D\001R\217;\354\233\325\306Qw\007\215!\222\223\350=\361;I\013k\312z\324\034\367\217`}\266N\322W\347\210\313\201\277\200\261\021\305S\3554\0164\353/\235\212+ \241\255\224[\035\352_Y\352\336\334V\355{\022\026\255\276\212\206g\213a\316\314aP\301NL\226\324\205\277\324\260\376\270\323\013\365\320H\342Ok\365;p\2604x~8\007\037l\241\224\342$\231\201,\250\014\257\254\376\274%\017\004\221\211B\310\233!\367k\247{\0034\361h\251`C\203\3374\211\341\317\031\371\361\241\003\335\263&\245Yy\210\3751Q\007\203\265\272\012\333\275P]\321k\004\344\257B\030\223\355\253\300Z\275\235V5\345aZ\347na\026l\006\307[\357kJ\235L\010\275\2547_\354g\260\217_<\325bS]\345\323}\372\004\265\325\316\363F\203``\016\276\311\272\212@q\246\361\313\251\317\231\315\204WNM\020\357j\357J\275\023\224\312\330Pv\\ \351\310\262\221\325\306\340R\223\263l()\340\324b\027y\233\307\006Mw\014\277\021\247\313|\014\200\346\0339\225\030\226\037\014\036\336\354];\216\221`\205\270\"(\021^\302]\002xw_r\005\262i\027\222\241\365\347\314\303\335\233\236\036\344\355\036l\364\345p\275\227\265\207\370\374-\313\343K\211\017\016\345E\014t\026\217\017\004\026\314\025\325\301\320\325<\352[\022,\013\346:\"\370\333\035\257\326=\234\021\015\021V\253*n\201T\031\260\235jb\350\210\023\372SL\215\375\206\014,\243%N\250c\253l\350\346\3247X' \252\031\300\326\342\363\306%\21651o\002\302\236\337\272dM\267.\336j\336s\246\361\363\365\003X\366O\311F_\036\342\022\3111\013\372\215\261F\215@\201a\206\334\032\371k\271\201\252(\332(\241E+\350\020g\316\334\\p\333E\003\270y\336\025qDB\253L\212J\240\270\275\355\\\303%=0\236`\350l\224PU\031\032g\237EJ\345\343\230\220e&\324\314\031\251 \266\"&\370,R\000A\217]I\013CuC[\214\264}\341\377\224N\3702\350Yh\360\005?Y\232R\350\323\264L\240\345\033\222\211\001\362\275W\243wL\323\204\267#\340\027\266\224\255|~\024m1FW\177\320\320\303\232\313\321lM\027\307\347\222\2573\273\366J\205\252p\023]\354^&\360\230+J\2759\333.\347\362\363\013\202ViJ\332T\217*\321D@XGj\241U\026\011\004\357A\200\236\221\345\020\271\016\220pU\365\363\374_\362\276w\\\3051\314\230\324\004\205h\035\2670\264\314\3356\012>\371\313\323\333*\251\361\341\376^\015\033\317\020xn7@\257\377\244\350\267\226\201/\214\001\213[\267\324\252F\341B\345\216\253>\012\223\000SrOX\015\260\272<\341\314\260\307\370\247Vw\012$\026\344f\347\303\362d/m\356\361%\205\354\012\273\341\264\365\354\376Q\352Y*\033\316E\377T\367\2006\3423\204e\371\355\267\254\307o\355\343\2152\226N\315'\264\324,\033e!\2549\215:\200\221\034\245\250@\254{\342\032Q\013U\335;\345\251\2728\302\265\351!\206\235N\035C\316M\310%\343Ad)\015\360\251?Z\216_;\363\342\320\345\005\360\011\246\034@\002\035Y:\261\006\221\305\263\347\037\356j\035PT\221\344lF\202\302F\022?WqS\330\216\330\373\271\364\013v(\274\242\327N\215\250L\343\214f\315\362\335\3044xFvjm\027\232\201\322\3505\001\265GV&\374$\237t-\006;=\034<\364\212\203JbA\033\245\016\011U\212t\263\271\320\327\010(\362\315DAQ'\032|Tmjl\260dg\262L\276\245\004\244[\211I\234\232\311\211[\337\367W\006t\327\222V\372\371\024J\224\220\361\231\030\317)!\306\014*7\220J\267H\343\215\376\232\312\351h\277\336\204\010\223M\260D\021A\262\227F\215&\022W\324KvWf[\001\251:\205\243[\006\310\366\031\360\012\304\371\360\252\222\271q8\\\330\020\353\247\034\377U\327\232\243-d\347z>J\005W\206S$\006rH3\221W\3339\022SN\235\012}W\221l\324\207\324s\260f\336\002o\304\356\012v\201\015gY\352\370M\273$\277\3576'Hv\002\335\017\022\023pwCJ+\300)\0031df\214\020#\360]\352\253Wg\316\010H\256\260C\277\"\362O\355\216\346\301O\236\030E6\340\224\330\023'\343A\002+V\213\337js\253\347\203-\265\035\252\370\304\330\216\333\243q2\016\323\026#-8\332\326\027\225\231\222\015(\215aa\002\036\312\33592y\247\020\313\004\314\234\273\025\253\262\003\032\317l\217\3625\251)|\346\346\342*S\012\341\354\245\277:\177R\316c\323\243\213\246}W\351^\311\017c\343\371t\271w\360vWRrA'\376\347Y`\255+ \022\311\273\030ar\372\317\214I\215f\334\226\310\3604\035\321\211\026!\035-\210\016$J\222\212\336\2072\"\243}\003\020\236r\316\321{\007f\363^i\323\363F\270\375\323\267f\355\022\032\002W%1\347)\016\357E;\360e\200@3\017\263\322\240\205\236qP\\`\207\220[H\217\023V\012\207\262\311+\323\272\314k\257\365\205\0126S\300\347\023\027\264\340\310<\323M\251\312H\037\312\236\025\267\277\023E\313\343\002\227\234\250~F\212G\015GKt\377\311\026S7\272^\347X\012\375\367S\020'\015\330\006\\\217)\373\222\257\212\263\245\244q\261\331*G\350\003kq\305s\346\002Y]\335\362l\214\332#\226-\364[\370\345\362\332w\230#\351h,t\\\343\207u\327\324\031\263\3709\250\315d\31376\007\022\026\310\243\222\231F\374\230\011\301}\363e\374\317,E\366\355\352\030\205\274\324\272\373\311E\230\352\200\2364\214(S\304\301\266\305\377\324\030fY\361\232\314o#u\3323\324g}\307q'\233\244,\221UW\207\217w~\"\2620\326\201\024C`)\3507\3444\306\204\022\013S$\341\266\332\306\260]\256xg\305y\223\236\007\2012/G\244\357@e>\034\274\014\246\031\246\034\362\203\363\253\242\376\331.Qb`a\357\023\270\003\357*\337\361uy\225\007\243\332\234\310\252\3310\321?z\314)\326\270MV\377\264E\037\263\202K5A\206\217\243\213\276b\354\002J\265\364\365PC/\012\002\030Gv\024)F\371\333j\004'\233\243\255\010L\234'P\032\244\245\300\366GP\200\035\346oM.\234\352\361\011\271H\354\346\341\237\013Y~\032\325\222g\201\022\017L\274;\336\364E\234\233g9&\237\316\331\206\004\304\243@\310\347\376U\323)C\275g\202\307\331\267\013\026\251\026\220D\372:\214\303\225\263\033\214kLX\247\327\213 \357D\316\234\006\356\010\000\307i\373Wl\323m\372\232:etI\314\371\241\031\252I\032\036I\236gU<\204\370\252\374\231\240\240\350\246\271\332=f\013\257\367\347\3108\020\266\210\222\021s3(\357\340\374l\256{\2759\035\304\033\013\253j\332\205\310M\327\204\215\317\232$\220\037\331\226\301\330\235\252\354P\357\226r\030\254l6\343f\342E\310\221`\251\034\012\3411\3131\255\201\024\024%\274#\001\206w;\241B\032\237yf\354\226\245\363\275\370\375j\243#\311\001\3703\200\247\023\312\303j\317\221\027ve\314x\351$~j\305\325\230\272l\371~\344\3552\231\306\304\314\217\306\362M\337\337l\266\367\222\365\012w\311\025\317\350K\234g*\370\366\331\201U\313\332\277\266\340c\003\305?|c#\330\226\241\272\352\253R\206\2635\313\271\034w\226\201!\305\257g8\263PR=\200'<\221F0'Y\260X\267\034\207/\233\373\270\034\010!\014\357\274\316}o8\362\371\233O\202fs\246\204p\305k/\267\212\007\2047U\335X\353\032)b\366\224\231R\233\316\314\361\027<\2365\035<\222\344t\326hr1(e\267t\306\254\324\321\347S\341\241\235w\267.44\330/\024\245I\016\214\3069dU\336\276i\221`\032$s\215\372\272\203g!<uc\376\303\033\351\367K1\233\361\225u!\305\247\253bJ\316\360\004/\225\320\236\035Z\026\352\373\240\347\357\346\014\273\200\022\250*\267\3403\372-\336\035\"\011bM\246Z\015\250\025\\\216U\352\215\241\007\366\231\256'\357:{\260\024\372?\222\2037\265-\323\306\373N2\301\256\266S\273\215\313\021$}\350u\377\307-\326\241J\\=\022\375D\234\303\340\0006j|\310\323KV\265\325\321\017\245\317\240\03264T=@\010\305\217\224\002eb\265\273\034\273r\255\300/\033\225\235;ZQ\320\\\000?\301I\225\037\341\250u\367\0054Be^\014\200\335U\017SF\332\\k(\015\3020\300\013\216\314\245\220\223\243\322o&;\253S\240?\336j\336s\246\361\363\365\003X\366O\311F_\036\320{\311\3119x\310\364\303\322\277\017\260`\342\2336\32048kc\336\205|>|\363c\216\300+\320\236\035Z\026\352\373\240\347\357\346\014\273\200\022\250\266\335\226h!:\021\000J|\217\341\214\362t\346\206\364\350\255\301q\222\037\243\355\006\275\301\021\307\305\322\006\217\012/X0\263\317W\202\003\313\0062\337\373\260\232\235>\221\363.\376d7\215W\340\177)\321\364\177@\244$\311\303\351\021\"2I;\312\34083%\273w+}\252;\015\313\320%D\220\011\020XF7\011\277\301\260\024\203\300\"_\014\025\030=d\260}\234\337\225w\210\206\240n~+\202\227\0356\312\240\005\204\034\211\0208\256dd\344:\036\030R\202\331\012nS&\033\015\362guJ\345\362\233\347\025Bb\261f\314\242\330\363ReG\334\314\305\203\001\217\354\006\322oz\311\007Q\034\036G\007\034\012\3411\3131\255\201\024\024%\274#\001\206wP\346t\361\215\214hya\030\331\340\361\216\002\352u2\344vQ\355\252\264]\377\211\361#:D\334p\006<\253[\000;\224\370\270_sCh\353\367\037=\010\254P\022]\332F_3\025\005<\322\230bc\271\277\370~\377\275\303\237e\235H\024XE\315\375'\353\0315\244\002\213\247\311\020t\216 \305\277\362\370\346y(\\v\024\334\024@$\031\031e7\236\233\004\365h*\321%\027{\274\316\362^,\304E\034VX\363\347\022H\203\243\264\234\002v\313\006\260i\004\204\302\212\020\315\023\003\310\335\005`^\266>\337\202}\177\022Muo\031\375a\3507\344M\315\012a\203/\223g~\243\211\274?\241P\324\012\007X\366\210!z\216d\021\223\271J\207V\230S;\017:\264LWr\310\315\257\330+j\305\270_\375\263\346I\003\234\225\246A\266\223\002\345\330:\227-\\\022\357\271\346\332\032\305r(?\245\325\030[@TcK\375j\017\367\323\305\324j\236\212d2\343 \333Jo4]C\245\375\276\037\350\243\014\316\216\205\311\336\313\031-\275\371\310\345\344\221Z!#\211+.\213\002\350\341\244\007\210\271\222\015'\032\204\321\342\\\255\265lmR\250\276\340\254Q\275q\202\264s\224?\216eM\014\177w\277\014\\\002\261Mo\373HwU4\333\332\365|nO\342\355\331T\224/\011\222\305\316a\316?2B\345\247,Ph\340\"\213\344M\220\270\216\372\211\342\245t\357\2067\227\032\206\220\300\242\211\353\2473\335oV-\202\342{:'\260{\340\014\271\021\376\202@\010/\233s\205\3078\255v\344@\262\370\021\242\253!\342\026\015f\270z-\006t\032\306\036N\177\015\340\212\255\032@\305n\037\020\243\217\024p\212\330\316h\317\357\350\003\016\215\326\021\326jt\361AM5H\331\236\345\312\302|4\232\245c'z M\000yr=\362\326C\251\305A\257\315=\013\334\251\276\373\022U?h\214\311\264t\272\034wl\015\355\236Kv]\033<g\332\247'\344\3305\317=I\246,<\375\372\276%\310\361\231\306\027\334\321\205Fv\034\254\230Q\275*Zuij\263\201C\270\005\360\242\214\332\220\016W\377\022\245\353\\d\250\237m\327\303#rd5iRS:\225\2307*c\333\213\350\310Z\2341Sc\210\326\2177i\004]\252\032b\340t\004\033\361r]\230\340\212\255\362\272j\006\010\222M\021&\036\270\222j=\212\276t\\\232\030*\315\322\267\002\006\333\364!\340\313x>\265\243h=1\303$\305>\202\221\357!\177\376\015*\276^-\324\276:8\016\030\330\341\245\011\000 \237\365\340\245\2744U\344\372%\342Vn\005\214|\237\335\224\002\330\274\326\037j\326\247\251W\375\177v\214R\006G\261J/\376\307\246\314>\215#\024\334\010\373\366\310\024fV(w'2\226lT\373yvSj\007z\025\344\365\271o^j\200\271QD\3463\267\270\372&e?\023\022\346\311\301qn\277\234G\260r\227\374\362\235\367\372r\241\320g=\303l\371]\214\360\005\325\202\336\006\201\206\275H\241+\256\355V\231\232\367\224\312\330Pv\\ \351\310\262\221\325\306\340R\223=+\012\305\254\007\0306^\317Wm\225(\376\007\253\256\205\313l\220\250\256\235\333\254V\226'\263\317\342@\344v\365\234)Z\027\366\355\370L\216\342\333:'\360_\260s\375\350\371>\206\217\325\325\037*\200\363.\235\020\000\2414\312\302\326\005\330\365-&\257\341\222\262\242IB\247'P\314p\312\3224\244\270\251OZ\033q\362\222\245\252\334\225\024\212\307\271\206#\233j\230\211P,K>lP\267>i\317\032B\252\257H\237\351y\26300o\200\2512\261l\312\373\336n\226?\272\366}\365PQ|\210|\004\0265\376\222G\306){\213\037wHU\261e\034:\177\365\206ig;M\371\253\211Ds\2535\302o\010j\0335\276\267\306\035\261a\307\236\265\377\312r\324\347\272\367\364w\336|)\302$\233\374\327\321\325\"\243\245{\302\317%\"\213x\277\222\031\267\235 \271$\267\3539tQ\252\305&\302\306\221\363\3644}L\030S\320\015\214\343\2559z\177+\217\207\204I\3734\203\300\035\030\321S\322\315\371\251$\345\314\270\337@\234\276\313\262D\253\233,S\257\335\323B\245\311\214\361Zxu?RL\016j\325\277/\374\217\257\331\240 \331\235\364\313\032vQ\212`\224\035\336\373{o\003~\233\262_\234\317\200X`\352\234/\244\377[W\245\\\015\223\\\352is4\011S\365\\:\211\"\324\275\211\345\322\276?\204\275\221\026\224z]\334\243\027\230AEA\261C\204u\215\220m\323\243\275dit\325\003\370o\345\363\033\301B\035\315c\315_\355}\326\002\371/3]\227wm\250m\326%r\233\314)Q\222\3149q\010Ui\330.\243\366{\333\236\300\312\245\261\353 ^\216(\222\341\277\236\233]\233\237\343\225}L\034u\360\325 *\265\207\304O5o6\377\333\314\354\346\006\355%Jq\327\2309r\307\275\240\346'\357\250\016\002f\306\233=\326_B\025\203u\320\177\202\373vf\225\007\215ET\214\256R@\011\327\306\263\243G\275\3044R?\337?\011d\304\272\021u\276\377`A\302\200}4\364\000'\261Y\037\013{\376\234\022\255\353\011\246\262\317Oz\344\340\334\261\317\243A+\375\007R\314\020\034\336\256\017\354=\352\014\377B'Xs\204\357t\211\032\200\303\3104B|\014\357W\177\357\327\256\377@\346\310|\263\226*\031X\316\3670\326;.\234\256\361\353\012/\377\316N\227\255\321\202h\231W\231\307\245\277v\252\255e\214\245i\212)\330J8O\351\354\312S5\267\356\365\347\205\377\370\320\205\330\331.\036\312\366\341\2103a4JM^\200\316\362\335WpY3\372z\326\324\326\201\322K\034\207?\342\353\362\372-\361\340H\2263\033\352\371\253,\364\352\236h\273\346\254q\002\323\227\007\272 lI\234\365\010<\257\021\246z\177\000\354J\264z\374*\202\345\260?\225\323\002g(\253\366,'\031o[|2\317L\260\016s\275\272_HF\316\362\2773\010\005\311E\301@\025H\015\273\306\333p\341H\360\272>n\355\353+\022>c\320S\221\010\2333\246}\215)\014\015\206\350}\275\242\255\017O0\235\340\270\235d\006\0007a\336G\217\321\337\300_\310\352\312\234\221$IJ=4\374uU\014\200\013\250\332E\2048_M\217\232?\035\234\212x\274\373\376\331t\204\242\316\212\352\372\177J\025\215\030=gj\0325\273\247\355r\321\250\217\226\312\374r\214\361tx.\310\321\256\002\273\332\321\226\276\223?\234\263\300\202\3659\005\322U\202I\266\012\337\327G\267\311\240\250\333\254\343\340\245\026r\001K.\240\263\232\\\355\265\247\206\205=\\\010U\300}\323\245D|\311\275\212\177S'\006,\235Jk\372\017\350]=U\363\310O\274\022k+\251~WWx@E\331\337 \207.\203\323\360z\347\370\267G#\361nZ\304>?F\331\271\\\362`w\326vE\330\227\353\257AiWzl\367N\205\376\316\001\000%z\354\034\005\237m\0379J\213Q}\334I\214\243\334m1\223\211AWM\362G\262\302\027\301i?\345\275u,\230U\371k\025I{=Rf\214\274Xw-\352S\373\340iw\\%\254.\300$a\302\362\326C\251\305A\257\315=\013\334\251\276\373\022Uz\000\233o\016l\254\203\304\003\330\304\026\023\237\011\343IdWp%|\233\345\310r\317\333-;*\275\330\331\016n\347%\361\351\223\262\303\315\011\246\007\007M\345f\3446\233\266?\011i\035\2567\321\240\370\035\303\305\206\262\327\021\367\300\223!\223\\\377\256{]-e\020\357\252feZ\324\322\032\2056\203\326\346\265OX$\031\2678\034\203\242\015\010\351\306&\240\214s\216 I\347\371\253\005\214'\036\017\263Yi\026\351\355\302\337\023M-\242Y\205\226\266\366\\\204\340\011G`\250\233\314\346\270\352\033\030V\260\216.]}\0168\323\205\022\034\204\301\346P\351\273\202\263/&\351\234\362\033\221N\215\273$\221\206\304\354\265\312^a\220\037F\271\267]N!\227}[\267\277\273\371`b\212\260\263\021\177e\202\263l\245rL?\374`\033\311\306HP\364\247E\240\334\036`\305\031Z\334\012\270.X*\271\212\307\367\027\335\346\325\354\254]\274\273\220\005\365\245\243\372\033\230 \254\200\244\230\026w\031kA\214\356\011\300(v\263=\247R\203\345\273\356q\313\207\235\333\342ya\356\002x\202\354\305M\003\315\263j\237\200\252\323\005`\370\030Y\343'\033\226\351\010\237\2570w\357H2\002x\202\354\305M\003\315\263j\237\200\252\323\005`4\034\243\335\245,%/\006#\375\215\310\251TG=V\304\215_\247\247D\235G\347P\245 \035\001T\252\357\230\373\315\300h\003\204\372v\241\312p\272W\313\355B&\246\273\\\272`\316y\257\264\017\240\010\331\253\247\206\300~\362\315\260\242\031\224\\_\000\254\265l\355Y\325N\242-\263\025)M\327\253]#j\245l^v\234D8\266q\212\235\360\\\023\353\002\231,x\251\\\370\214\355T\267\250\351.\262\026\224N\037_\302\374\000\343-\012\256\310\211\314\225\315>\006\323\266\034r6\025N\220(\223\366\320\377\013\342\240\315\010~\201\364\204\024\356\365\200A\021\215m\001S\005A\207z\333w\020\227\376\251\240\315e&-3\000\312\374\212o)\002APc\314\\]k#:\236\216\212\300y\323\302T\007D}P\314\330\306\310\024\350\024cD\211H\317\273/\354\360 2o:\366\267\357\007\236\340\326\354\256\371N0\252\022\277\356tU\377$\233\20444\255l\315F\330v6H6\372\241\272\262u(5a\253I<\210\272W\214^\203\205k\342ij\270\332_\254\204.\033\212\005\3368P\251\212\346y\011-t\252wP\262I)\012#\263\273\351\257|\210\332\023\00551\307K\213t\343\257O\335U\272\277\365q\017\2439*\325d\300v\201\254\206f\321\025\235\377\376\222\377I\036.\324I\024PG\016\275\315Z\243Bm\3319h\201\272\342h\353r\324.4\311t\313\013\273\\\"\332\273\003l\312M\2114\031\366T\357\352a\364\340\274\021\262\274\022\272\226\272T\\\"\332\273\003l\312M\2114\031\366");
		buffer.rewind();
		return buffer;
	}
	private static final Map<String, Range> assets = initAssets();
	private static Map<String, Range> initAssets() {
		Map<String, Range> assets = new HashMap<String, Range>();
		assets.put("app.js", new Range(0, 480));
		assets.put("notas.js", new Range(480, 6768));
		assets.put("_app_props_.json", new Range(7248, 112));
		return Collections.unmodifiableMap(assets);
	}


	public String readAsset(String path)
	{
		TiApplication application = TiApplication.getInstance();
		boolean isProduction = false;
		if (application != null) {
			isProduction = TiApplication.DEPLOY_TYPE_PRODUCTION.equals(application.getAppInfo().getDeployType());
		}

		if (isProduction && Debug.isDebuggerConnected()) {
			Log.e("AssetCryptImpl", "Illegal State. Exit.");
			System.exit(1);
		}

		Range range = assets.get(path);
		if (range == null) {
			return null;
		}
		return new String(filterDataInRange(assetsBytes, range.offset, range.length));
	}

	private static byte[] filterDataInRange(byte[] data, int offset, int length)
	{
		try {
			Class clazz = Class.forName("org.appcelerator.titanium.TiVerify");
			Method method = clazz.getMethod("filterDataInRange", new Class[] {data.getClass(), int.class, int.class});
			return (byte[])method.invoke(clazz, new Object[] { data, offset, length });
		} catch (Exception e) {
			Log.e("AssetCryptImpl", "Unable to load asset data.", e);
		}
		return new byte[0];
	}
}
