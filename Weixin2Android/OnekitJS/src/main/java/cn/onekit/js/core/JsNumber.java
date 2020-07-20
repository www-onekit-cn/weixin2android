package cn.onekit.js.core;

public class JsNumber implements JsObject{
    public static final JsNumber EPSILON = new JsNumber(2.2204460492503130808472633361816E-16);
    //
    public static final JsNumber MAX_SAFE_INTEGER = new JsNumber(9007199254740991L);
    //
    public static final JsNumber MAX_VALUE =new JsNumber( 1.79E+308);
    //
    public static final JsNumber MIN_SAFE_INTEGER =new JsNumber( -9007199254740991L);
    //
    public static final JsNumber MIN_VALUE = new JsNumber(5e-324);
    //
    public static final JsNumber NEGATIVE_INFINITY = new JsNumber(Double.NEGATIVE_INFINITY);
    //
    public static final JsNumber NaN = new JsNumber( Double.NaN);
    //
    public static final JsNumber POSITIVE_INFINITY = new JsNumber(Double.POSITIVE_INFINITY);
    static char[] chs = new char[36];
    static {
        for(int i = 0; i < 10 ; i++) {
            chs[i] = (char)('0' + i);
        }
        for(int i = 10; i < chs.length; i++) {
            chs[i] = (char)('A' + (i - 10));
        }
    }

    ///////////..........///////////
    public static JsBoolean isFinite(JsObject value){
        if(!(value instanceof Number)){
            return new JsBoolean(false);
        }
        return new JsBoolean(Double.isFinite(Double.parseDouble(value.toString())));
    }
    public static JsBoolean isInteger(JsObject value){
        return new JsBoolean( Onekit_JS.isNumber(value));
    }
    public static JsBoolean isNaN(JsObject value){
        return new JsBoolean(!Onekit_JS.isNumber(value));
    }
    public  static JsBoolean isSafeInteger(JsObject testValue) {
        if (isNaN(testValue).THIS) {
            return new JsBoolean(false);
        }
        Number value = Onekit_JS.number(testValue,0,0);
        String string = value.toString();
        int dot = string.lastIndexOf(".");
        int zero = string.lastIndexOf("0");
        if (dot<0 || (( dot== string.length() - 2)
                && (zero== string.length() - 1))) {
            double d = Double.parseDouble(string);
            return new JsBoolean( d >= MIN_SAFE_INTEGER.THIS.doubleValue() && d <= MAX_SAFE_INTEGER.THIS.doubleValue());
        }
        return new JsBoolean(false);
    }
    public static JsNumber parseFloat(JsObject string){
       if(!Onekit_JS.isNumber(string)){
           return new JsNumber(0.0);
       }
       return new JsNumber( Double.parseDouble(string.toString()));
    }
    public  static JsNumber parseInt(JsObject string) {
        if (!Onekit_JS.isNumber(string)) {
            return new JsNumber(0L);
        }
        return new JsNumber((long)Double.parseDouble(string.toString()));
    }
    public static JsObject Number(JsObject value) {
        return new JsNumber(value);

    }
    ////////////////////////////////////////

    public Number THIS;
    public JsNumber(Number value){
        this.THIS = value;
    }
    public JsNumber(JsObject value){
        if(value instanceof JsNumber) {
            this.THIS = ((JsNumber)value).THIS;
        }else{
            this.THIS = 0;
        }
    }
    public JsString _toExponential(Integer fractionDigits) {
        String string = this.toString();
        int len = string.indexOf(".");
        if (fractionDigits == null) {
            if(len>=0) {
                fractionDigits = string.length() - len;
            }else{
                fractionDigits = string.length()-1;
            }
        }
        String str = string+"00000000000000000000000000000";
        if(len>=0) {
            return new JsString( String.format("%s.%s%se+%s",
                    str.substring(0, 1),
                    str.substring(1, len),
                    str.substring(len + 1, fractionDigits + len),
                    len - 1));
        }else{
            return new JsString(String.format("%s.%se+%s",
                    str.substring(0, 1),
                    str.substring(1, 1+fractionDigits),
                    fractionDigits));
        }
    }
    public JsString toExponential(JsObject fractionDigits) {
        Integer fractionDigits_ = Onekit_JS.number(fractionDigits,0,0).intValue();
        return _toExponential( fractionDigits_);
    }
    public JsString toExponential(){
        return toExponential(null);
    }
    //
    public JsString toFixed(JsObject digits){
        if(digits==null){
            return new JsString(String.valueOf(THIS.longValue()));
        }
        int d = Onekit_JS.number(digits,0,0).intValue();
      String format = "%."+d+"f";
      return new JsString(String.format(format,THIS));
    }
    public JsString toFixed(){
        return toFixed(null);
    }
    public JsString toLocaleString(JsObject locales , JsObject options){
        return new JsString("");
    }
    public JsString toLocaleString(JsObject locales ){
        return toLocaleString(locales,null);
    }
    public JsString toLocaleString(){
        return toLocaleString(null);
    }
    public JsString toPrecision(JsObject precision){
        return new JsString("");
    }
    public JsString valueOf(){
        return new JsString("");
    }

    public JsString ToString(JsObject radix) {
        int r = Onekit_JS.number(radix,10,10).intValue();
        if(THIS instanceof Integer){
            return new JsString(THIS.toString());
        }
        if (r == 10) {
            return new JsString(THIS.toString());
        }
        int number = THIS.intValue();
        StringBuilder sb = new StringBuilder();
        boolean isN=false;
        while (number != 0) {
            int index=number%r;
            if(index<0){
                isN=true;
                index+=r;
            }
            sb.append(chs[index]);
            number = number / r;
        }
        return new JsString(isN?"-":""+sb.reverse().toString().toLowerCase());
    }

    @Override
    public JsObject get(String key) {
        return null;
    }

    @Override
    public JsObject get(JsObject key) {
        return null;
    }

    @Override
    public void set(String key, JsObject value) {

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