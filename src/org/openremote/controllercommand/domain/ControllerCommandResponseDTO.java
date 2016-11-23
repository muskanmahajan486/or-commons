package org.openremote.controllercommand.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ControllerCommandResponseDTO implements Serializable
{

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * The type of command. This is required because not every command needs a subclass
   * from which we can infer the type from.
   */
  public enum Type {
     SUCCESS, ERROR;

     /**
      * Gets a label for this type, this is useful for exporting. Label format is
      * name().replace("_", "-").toLowerCase().
      */
      public String getLabel() {
         return name().replace("_", "-").toLowerCase();
      }

      @Override
      public String toString() {
        return getLabel();
      }

      /**
       * Gets a type from a label, this is useful for importing. Label format is
       * name().replace("_", "-").toLowerCase().
       */
      public static Type fromLabel(String label) {
         return valueOf(label.replace("-", "_").toUpperCase());
      }
  }

  /** The id */
  private Long oid;

  /** The type of this command response as string */
  private String responseType;

  /** The type of this command response as enum */
  private Type responseTypeEnum;

  public String getResponseType()
  {
    return responseType;
  }

  public void setResponseType(String responseType)
  {
    this.responseType = responseType;
    if (responseType == null) {
      this.responseTypeEnum = null;
    } else {
      this.responseTypeEnum = Type.fromLabel(responseType);
    }
  }

  public Type getCommandTypeEnum()
  {
    return responseTypeEnum;
  }

  public void setCommandTypeEnum(Type responseTypeEnum)
  {
    this.responseTypeEnum = responseTypeEnum;
  }

  public Long getOid()
  {
    return oid;
  }

  public void setOid(Long oid)
  {
    this.oid = oid;
  }
  
  
  
}
