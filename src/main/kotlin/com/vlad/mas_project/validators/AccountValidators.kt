package com.vlad.mas_project.validators

/*fun validateToken(token: Token, tokenRepository: TokenRepository){
    if (token.value.isNullOrEmpty()
        || token.userId == null
        || token.time == null
    ) throw BadRequestException()
    val oldTokenOptional = tokenRepository.findEmailExistsErrorById(token.value)
    if (oldTokenOptional.isEmpty) throw ForbiddenException()
    val oldToken = oldTokenOptional.get()
    if (oldToken != token) throw ForbiddenException()
}*/
/*
fun validateUserAndCheckIfEmailAndNicknameNotAlreadyInUse(person: Person, personRepository: PersonRepository): BodyBuilder {
    if (person.email.isNullOrEmpty()
        || person.password.isNullOrEmpty()
        || person.name.isNullOrEmpty()
        || person.surname.isNullOrEmpty()
    ) return ResponseEntity.badRequest()
    if (personRepository.isExistWithEmail(person.email) != null) throw ApiEr
}


fun validateEmailAndPasswordThenReturnUserId(loginInfo: LoginInfo, userRepository: UserRepository): Long {
    if (loginInfo.email.isNullOrEmpty()
        || loginInfo.password.isNullOrEmpty()
    ) throw BadRequestException()
    return userRepository.findByEmailAndPassword(loginInfo.email, loginInfo.password)?.id ?: throw ForbiddenException()
}

fun validateChatCreator(chatCreator: ChatCreator){
    if (chatCreator.token == null
        || chatCreator.data.isNullOrEmpty()
    ) throw BadRequestException()
}

fun validateMessageCreator(messageCreator: MessageCreator){
    if (messageCreator.token == null
        || messageCreator.data == null
        || messageCreator.time == null
        || messageCreator.chatId == null
        || messageCreator.type == null
    ) throw BadRequestException()
}

 */

