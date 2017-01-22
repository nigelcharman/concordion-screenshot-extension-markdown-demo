# Owners

Owners must have a first name, last name, address, city and phone number.

## Creating owners

### [Example - duplicate](- "duplicate")

Given [Deanne](c:set=#first") [Doolittle](c:set="#last") of [1 High St](c:set="#address"), [Puddleby](c:set= "#city"), phone [(01) 123-4321](c:set="#phone")

as an [owner](c:execute="#owner=createOwner(#first, #last, #address, #city, #phone)") is [added](c:execute="saveOwner(#owner)"), creating a [duplicate owner](c:execute="#dupOwner=duplicate(#owner)") and [adding](c:execute="saveOwner(#dupOwner)") it results in an error. 

Searching for owners with a last name of '[Doolittle](c:set="#lastName")'

|[find][][owners][]|
|-----|
|Doolittle|

[find]: c:verifyRows="#owner:findOwnersByLastName(#lastName)" ""
[owners]: c:assert-equals="#owner.lastName" ""

### [Example - isolation](- "isolation")

Searching for owners with a last name of '[Doolittle](- "#lastName")'

|[find][][owners][]|
|-----|
|Doolittle|

