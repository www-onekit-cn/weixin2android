package cn.onekit.weixin;

import cn.onekit.js.core.JsString;
import cn.onekit.js.core.JsObject;

public class FileItem implements JsObject {
    public String filePath;
    public int createTime;
    public int size;

    @Override
    public JsString ToString() {
        return null;
    }
}