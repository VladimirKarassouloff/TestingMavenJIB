package jib.service.author;

import jib.dao.author.AuthorFilter;
import jib.model.entities.AuthorEntity;
import jib.service.IService;

public interface IAuthorService extends IService<AuthorEntity, AuthorFilter> {
}
