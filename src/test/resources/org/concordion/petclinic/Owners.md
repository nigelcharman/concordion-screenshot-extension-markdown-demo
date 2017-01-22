# Owners

Owners must have a first name, last name, address, city and phone number.

## Creating owners

Duplicate owners are allowed.

### [Example - missing phone](- "no-phone")

Given [](- "#first") [Doolittle](- "#last") of [](- "#address"), [](- "#city"), phone [](- "#phone")

as an [owner](- "#owner=createOwner(#first, #last, #address, #city, #phone)")  

Searching for owners with a last name of '[Doolittle](- "#lastName")'

|[find][][first][] | [last][] | [address][] | [city][] | [phone][] |
|--|--|--|--|--|
|Deanne|Doolittle|1 High St|Puddleby|(01) 123-4321|

### [Example - duplicate](- "duplicate")

Given [Deanne](- "#first") [Doolittle](- "#last") of [1 High St](- "#address"), [Puddleby](- "#city"), phone [(01) 123-4321](- "#phone")

as an [owner](- "#owner=createOwner(#first, #last, #address, #city, #phone)") is [added](- "saveOwner(#owner)"), creating a [duplicate owner](- "#dupOwner=duplicate(#owner)") and [adding](- "saveOwner(#dupOwner)") it results in an error. 

Searching for owners with a last name of '[Doolittle](- "#lastName")'

|[find][][first][] | [last][] | [address][] | [city][] | [phone][] |
|--|--|--|--|--|
|Deanne|Doolittle|1 High St|Puddleby|(01) 123-4321|
|Deanne|Doolittle|1 High St|Puddleby|(01) 123-4321|

[find]: - "c:verifyRows=#owner:findOwnersByLastName(#lastName)"
[first]: - "?=#owner.firstName"
[last]: - "?=#owner.lastName"
[address]: - "?=#owner.address"
[city]: - "?=#owner.city"
[phone]: - "?=#owner.telephone"
