package com.idega.block.poll.business;

import com.idega.data.EntityFinder;
import com.idega.block.poll.data.*;
import java.sql.SQLException;
import com.idega.core.localisation.business.ICLocaleBusiness;
import com.idega.core.data.ICObjectInstance;
import com.idega.core.business.ICObjectBusiness;
import java.util.List;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class PollFinder {

  public PollFinder() {

  }

  public static PollEntity getPoll(String sAttribute){
    PollEntity poll = null;
    try {
      List L = EntityFinder.findAllByColumn(new PollEntity(),PollEntity.getColumnNameAttribute(),sAttribute);
      if(L!= null)
        poll =  (PollEntity) L.get(0);
    }
    catch (SQLException ex) {
      ex.printStackTrace();
      poll = null;
    }
    return poll;
  }

  public static int getRelatedEntityId(ICObjectInstance eObjectInstance){
    ICObjectBusiness bis = ICObjectBusiness.getInstance();
    return bis.getRelatedEntityId(eObjectInstance,PollEntity.class);
  }

  public static PollEntity getObjectInstanceFromID(int ICObjectInstanceID){
    try {
      ICObjectBusiness icob = ICObjectBusiness.getInstance();
      ICObjectInstance ICObjInst = icob.getICObjectInstance(ICObjectInstanceID);
      return (PollEntity)icob.getRelatedEntity(ICObjInst,PollEntity.class);
    }
    catch (com.idega.data.IDOFinderException ex) {
      ex.printStackTrace();
      return null;
    }
  }




}