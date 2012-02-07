package com.simplecash.ui.desktop.event;

import com.simplecash.dal.RepositoryFactory;
import com.simplecash.dal.repository.ContactRepository;
import com.simplecash.ui.desktop.component.search.SearchPanel;
import javaEventing.interfaces.Event;
import javaEventing.interfaces.GenericEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class ContactSearchEventListener implements GenericEventListener {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void eventTriggered(Object sender, Event event) {
        SearchPanel searchPanel = (SearchPanel)sender;
        String searchString = searchPanel.getSearchInputPanel().getSearchString();

        logger.debug("Searching for Contact name=" + searchString);

        ContactRepository contactRepository = RepositoryFactory.getRepository(ContactRepository.class);
        contactRepository.findByName(searchString);
    }
}
