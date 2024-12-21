package dev.naimsulejmani.grupi2bookcheckmark.mappers;

import dev.naimsulejmani.grupi2bookcheckmark.dtos.AuthorDto;
import dev.naimsulejmani.grupi2bookcheckmark.dtos.SimpleAuthorDto;
import dev.naimsulejmani.grupi2bookcheckmark.models.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary // per me i hjek nje error qe shfaqet vetem ne intelliJ po sosht error
@Mapper(componentModel = "spring")
public interface AuthorMapper extends BasicMapper<AuthorDto, Author> {
    public static final AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "bio", target = "biography")
    @Mapping(source = ".", target = "fullName", qualifiedByName = "concatFullName")
    SimpleAuthorDto toSimpleDto(Author entity);

    @Named("concatFullName")
    default String concatFullName(Author author) {
        return author.getName() + " " + author.getSurname();
    }


    List<AuthorDto> toDtoList(List<Author> authors);
}






