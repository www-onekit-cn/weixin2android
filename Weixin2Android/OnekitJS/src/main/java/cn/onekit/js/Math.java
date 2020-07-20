package cn.onekit.js;

import cn.onekit.js.core.JsBoolean;
import cn.onekit.js.core.JsNumber;
import cn.onekit.js.core.JsObject;
import cn.onekit.js.core.JsString;
import cn.onekit.js.core.Onekit_JS;

public class Math implements JsObject {
    public static final JsNumber E = new JsNumber(java.lang.Math.E);
    public static final JsNumber LN10 = new JsNumber( 2.302585092994046);
    public static final JsObject LN2 =  new JsNumber(0.6931471805599453);
    public static final JsNumber LOG10E =  new JsNumber(0.4342944819032518);
    public static final JsNumber LOG2E =  new JsNumber(1.4426950408889634);
    public static final JsNumber PI =  new JsNumber(java.lang.Math.PI);
    public static final JsNumber SQRT1_2 =  new JsNumber(0.7071067811865476);
    public static final JsNumber SQRT2 =  new JsNumber(1.4142135623730951);

    public static JsNumber abs(JsObject x) {
        if (x == null) {
            return new JsNumber( 0);
        }
        if (!Onekit_JS.isNumber(x)) {
            return JsNumber.NaN;
        }
        Double result = java.lang.Math.abs(Onekit_JS.number(x,0,0).doubleValue());
        return new JsNumber( Onekit_JS.float2integer(result));
    }

    public static JsNumber abs() {
        return abs(new JsNumber(0));
    }

    public static JsNumber acos(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        if (x < -1 || x > 1) {
            return JsNumber.NaN;
        }
        return new JsNumber(java.lang.Math.acos(Onekit_JS.number(v,0,0).doubleValue()));
    }

    public static JsNumber acosh(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        if (x < 1) {
            return JsNumber.NaN;
        }
        return new JsNumber(java.lang.Math.log(x + java.lang.Math.sqrt(x * x - 1)));
    }

    public static JsNumber asin(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        if (x < -1 || x > 1) {
            return JsNumber.NaN;
        }
        return new JsNumber( java.lang.Math.asin(x));
    }

    public static JsNumber asinh(JsObject v) {
        Double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.log(x + java.lang.Math.sqrt(x * x + 1)));
    }

    public static JsNumber atan(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.atan(x));
    }

    public static JsNumber atan2(JsObject a, JsObject b) {
        double y = Onekit_JS.number(a,0,0).doubleValue();
        double x = Onekit_JS.number(b,0,0).doubleValue();
        return new JsNumber(java.lang.Math.atan2(y, x));
    }

    public static JsNumber atanh(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        if (x < -1 || x > 1) {
            return JsNumber.NaN;
        }
        return new JsNumber(java.lang.Math.log((1 + x) / (1 - x)) / 2);
    }

    public static JsNumber cbrt(JsObject v) {
        if (v == null) {
            return new JsNumber(0);
        }   
        if (!Onekit_JS.isNumber(v)) {
            return JsNumber.NaN;
        }
        double x = Onekit_JS.number(v,0,0).doubleValue();
        double number = Double.parseDouble(String.valueOf(x));
        double result = java.lang.Math.cbrt(number);
        return new JsNumber(Onekit_JS.float2integer(result));
    }

    public static JsNumber ceil(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber((long) java.lang.Math.ceil(x));
    }

    public static JsNumber clz32(JsObject v) {
        if (v == null) {
            return new JsNumber(32);
        }
        if (v instanceof JsBoolean) {
            return new JsNumber(31);
        }
        double db = Onekit_JS.number(v,0,0).doubleValue();
        long l = Double.doubleToLongBits(db);
        double value = Double.longBitsToDouble(l);
        return new JsNumber(value != 0 ? 32 - (new JsNumber(value).ToString( new JsNumber(2))).toString().length() : 32);
    }

    public static JsNumber clz32() {
        return clz32(null);
    }

    public static JsNumber cos(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.cos(x));
    }

    public static JsNumber cosh(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        double y = java.lang.Math.exp(x);
        return new JsNumber((y + 1 / y) / 2);
    }

    public static JsNumber exp(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.exp(x));
    }

    public static JsNumber expm1(JsObject x) {
        if (x == null) {
            return new JsNumber(0);
        }
        if (!Onekit_JS.isNumber(x)) {
            return JsNumber.NaN;
        }
        double db = Onekit_JS.number(x,0,0).doubleValue();
        return new JsNumber(java.lang.Math.exp(db) - 1);
    }

    public static JsNumber floor(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber((long) java.lang.Math.floor(x));
    }

    public static JsNumber fround(JsObject doubleFloat) {
        if (doubleFloat == null) {
            return new JsNumber(0);
        }
        if (!Onekit_JS.isNumber(doubleFloat)) {
            return JsNumber.NaN;
        }
        return new JsNumber( Onekit_JS.number(doubleFloat,0,0).floatValue());
    }

    public static JsNumber hypot(JsObject... arguments) {
        if (arguments == null) {
            return new JsNumber( 0);
        }
        double y = 0;

        for (JsObject argument : arguments) {
            if (!Onekit_JS.isNumber(argument)) {
                return JsNumber.NaN;
            }
            double number = Onekit_JS.number(argument,0,0).doubleValue();
            if (number == (JsNumber.POSITIVE_INFINITY).THIS.doubleValue() || number == JsNumber.NEGATIVE_INFINITY.THIS.doubleValue()) {
                return JsNumber.POSITIVE_INFINITY;
            }
            y += number * number;
        }
        return new JsNumber( java.lang.Math.sqrt(y));
    }

    public static JsNumber imul(JsObject x, JsObject y) {
        int a = Onekit_JS.number(x,0,0).intValue();
        int b = Onekit_JS.number(y,0,0).intValue();
        a |= 0;
        long result = (a & 0x003fffff) * b;
        if ((a & 0xffc00000) != 0) result += (a & 0xffc00000) * b;
        return new JsNumber(result);
    }

    public static JsNumber log(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.log(x));
    }

    public static JsNumber log10(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        if (!Onekit_JS.isNumber(v)) {
            return JsNumber.NaN;
        }
        return new JsNumber(java.lang.Math.log10(x));
    }

    public static JsNumber log1p(JsObject v) {
        double number = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.log1p(number));
    }

    public static JsNumber log2(JsObject v) {
        double number = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(number / Math.log(new JsNumber(2)).THIS.doubleValue());
    }
    public static JsNumber max(JsObject... numbers) {
            Number result = ((JsNumber)numbers[0]).THIS;
            for(int i=1;i<numbers.length;i++){
                Number element = ((JsNumber)numbers[i]).THIS;
               if(element.doubleValue()>result.doubleValue()){
                   result= element;
               }

            }
            return new JsNumber(result);
        }

    public static JsNumber min(JsObject... numbers) {
        Number result = ((JsNumber)numbers[0]).THIS;
        for(int i=1;i<numbers.length;i++){
            Number element = ((JsNumber)numbers[i]).THIS;
            if(element.doubleValue()<result.doubleValue()){
                result= element;
            }

        }
        return new JsNumber( result);
    }

    public static JsNumber pow(JsObject a, JsObject b) {
        double x = Onekit_JS.number(a,0,0).doubleValue();
        double y = Onekit_JS.number(b,0,0).doubleValue();
        return new JsNumber(java.lang.Math.pow(x, y));
    }

    public static JsNumber random() {
        return new JsNumber(java.lang.Math.random());
    }

    public static JsNumber round(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.round(x));
    }

    public static JsNumber sign(JsObject v) {
        double number = Onekit_JS.number(v,0,0).doubleValue();
        if (number < 0) {
            return new JsNumber(-1);
        } else if (number > 0) {
            return new JsNumber(1);
        } else {
            return new JsNumber(0);
        }
    }

    public static JsNumber sign() {
        return sign(null);
    }

    public static JsNumber sin(JsObject v) {
        double x = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.sin(x));
    }

    public static JsNumber sinh(JsObject v) {
        if (v == null) {
            return JsNumber.NaN;
        }
        double number = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber((java.lang.Math.exp(number)- java.lang.Math.exp(-number)) / 2);
    }

    public static JsNumber sqrt(JsObject v) {
        if (v == null) {
            return JsNumber.NaN;
        }
        double number = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.sqrt(number));
    }

    public static JsNumber tan(JsObject v) {
        if (v == null) {
            return JsNumber.NaN;
        }
        double number = Onekit_JS.number(v,0,0).doubleValue();
        return new JsNumber(java.lang.Math.tan(number));
    }

    public static JsString toSource() {
        return new JsString("Math");
    }
    public static JsNumber tanh(JsObject v) {
        if (v == null) {
            return JsNumber.NaN;
        }
        double number = Onekit_JS.number(v,0,0).doubleValue();
        if (number == JsNumber.POSITIVE_INFINITY.THIS.doubleValue()) {
            return new JsNumber(1);
        } else if (number == JsNumber.NEGATIVE_INFINITY.THIS.doubleValue()) {
            return new JsNumber(-1);
        } else {
            double y = java.lang.Math.exp(2 * number);
            return new JsNumber((y - 1) / (y + 1));
        }
    }

    public static JsNumber trunc(JsObject v) {
        if (v == null) {
            return JsNumber.NaN;
        }
        double x = Onekit_JS.number(v,0,0).doubleValue();
        String string = String.valueOf(x);
        int dot = string.indexOf(".");
        if (dot>=0 ) {
            string = string.substring(0,dot);
        }
        return new JsNumber(Double.parseDouble(string));
    }
    public static JsNumber trunc() {
        return trunc(null);
    }

    @Override
    public JsObject get(JsObject key) {
        return null;
    }

    @Override
    public void set(JsObject key, JsObject value) {

    }

    @Override
    public JsString ToString() {
        return null;
    }

    @Override
    public String toLocaleString(JsString locales, JsObject options) {
        return null;
    }

    @Override
    public JsObject invoke(JsObject... params) {
        return null;
    }
}