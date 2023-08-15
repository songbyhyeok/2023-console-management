package base.handler;

import base.enums.DtoEnum;

public class ObjectHandler {
    public static String toObjectName(Object object) {
        if (object == null)
            return DtoEnum.PLAYLIST.toString();

        String names[] = object.getClass().getName().split("\\.");
        if (names[names.length - 1].equals("HashMap"))
            return DtoEnum.PLAYLIST.toString();

        return names[names.length - 1];
    }
}
