package com.epam.messenger.message.manager.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.epam.messenger.common.model.SequenceId;
import com.epam.messenger.message.manager.dao.SequenceDao;
import com.epam.messenger.message.manager.exception.SequenceException;

@Repository
public class SequenceDaoImpl implements SequenceDao {

  private static final String DEFAULT_SEQUENCE_ID = "default_sequence";
  @Autowired
  private MongoOperations mongoOperation;

  @PostConstruct
  public void initSequence() {
    if (!mongoOperation.collectionExists(SequenceId.class)) {
      mongoOperation.createCollection(SequenceId.class);
      SequenceId sequenceId = new SequenceId();
      sequenceId.setId(DEFAULT_SEQUENCE_ID);
      mongoOperation.save(sequenceId);
    }
  }

  @Override
  public long getNextSequenceId() throws SequenceException {
    Query query = new Query(Criteria.where("_id").is(DEFAULT_SEQUENCE_ID));

    Update update = new Update();
    update.inc("seq", 1);

    FindAndModifyOptions options = new FindAndModifyOptions();
    options.returnNew(true);

    SequenceId seqId = mongoOperation.findAndModify(query, update, options, SequenceId.class);

    if (seqId == null) {
      throw new SequenceException("Unable to get sequence id for key : " + DEFAULT_SEQUENCE_ID);
    }

    return seqId.getSeq();
  }

}
