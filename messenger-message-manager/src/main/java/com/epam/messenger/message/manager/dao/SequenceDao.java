package com.epam.messenger.message.manager.dao;

import com.epam.messenger.message.manager.exception.SequenceException;

public interface SequenceDao {

	long getNextSequenceId() throws SequenceException;

}
