package s_gestion_alarmas.sop_corba;

/**
* s_gestion_alarmas/sop_corba/GestionNotificacionesIntHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from notificacion.idl
* martes 15 de marzo de 2022 09H40' COT
*/

public final class GestionNotificacionesIntHolder implements org.omg.CORBA.portable.Streamable
{
  public s_gestion_alarmas.sop_corba.GestionNotificacionesInt value = null;

  public GestionNotificacionesIntHolder ()
  {
  }

  public GestionNotificacionesIntHolder (s_gestion_alarmas.sop_corba.GestionNotificacionesInt initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = s_gestion_alarmas.sop_corba.GestionNotificacionesIntHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    s_gestion_alarmas.sop_corba.GestionNotificacionesIntHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return s_gestion_alarmas.sop_corba.GestionNotificacionesIntHelper.type ();
  }

}
