package org.ada.school.user.service;

import org.ada.school.user.controller.user.UserDto;
import org.ada.school.user.exception.UserNotFoundException;
import org.ada.school.user.repository.UserRepository;
import org.ada.school.user.repository.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB implements UserService
{

    private final UserRepository userRepository;

    public UserServiceMongoDB( @Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create( UserDto userDto )
    {
        return userRepository.save( new User( userDto ) );
    }

    @Override
    public User findById( String id )
    {
        Optional<User> optionalUser = userRepository.findById( id );
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User findByEmail( String email )
        throws UserNotFoundException
    {
        Optional<User> optionalUser = userRepository.findByEmail( email );
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> all()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById( String id )
    {
        if ( userRepository.existsById( id ) )
        {
            userRepository.deleteById( id );
            return true;
        }
        return false;
    }

    @Override
    public User update( UserDto userDto, String id )
    {
        if ( userRepository.findById( id ).isPresent() )
        {
            User user = userRepository.findById( id ).get(); //Usamos el findById debido a que la DB no está en memoria sino en la nube en este caso.
            // En caso contrario si la lista está en la RAM podemos solo llamar get.
            user.update( userDto );
            userRepository.save( user ); // Esto lo usamos si estamos almacenandolo en una base de datos.
            // En el caso de que lo estemos almacenando en memoria entonces no hace falta escribir esta linea.
            return user;
        }
        return null;
    }
}