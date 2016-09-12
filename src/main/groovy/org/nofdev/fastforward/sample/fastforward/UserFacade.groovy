package org.nofdev.fastforward.sample.fastforward

import org.nofdev.servicefacade.PagedList
import org.nofdev.servicefacade.Paginator

interface UserFastforward {
    PagedList<UserDTO> findUsersByNameLike(String nameLike, Paginator paginator)
}