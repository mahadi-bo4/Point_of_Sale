import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./auth/login/login.component";
import {ForgotPasswordComponent} from "./auth/forgot-password/forgot-password.component";
import {ResetPasswordComponent} from "./auth/reset-password/reset-password.component";
import {AdminAuthGuard, AuthorizedUserGaurd, UnauthorizedUserGuard} from "./router-guards/auth.guard";
import {PageNotFoundComponent} from "./errors/page-not-found/page-not-found.component";
import {AuthComponent} from "./auth/auth.component";
import {UserDashboardComponent} from "./user-dashboard/user-dashboard.component";
import {DashboardComponent} from "./user-dashboard/dashboard/dashboard.component";
import {ProductsComponent} from "./user-dashboard/products/products.component";
import {UsersComponent} from "./user-dashboard/users/users.component";
import {EditUserComponent} from "./user-dashboard/users/edit-user/edit-user.component";
import {AllUsersComponent} from "./user-dashboard/users/all-users/all-users.component";
import {AddNewUserComponent} from "./user-dashboard/users/add-new-user/add-new-user.component";
import {SuppliersComponent} from "./user-dashboard/suppliers/suppliers.component";
import {AllSuppliersComponent} from "./user-dashboard/suppliers/all-suppliers/all-suppliers.component";
import {AddNewSupplerComponent} from "./user-dashboard/suppliers/add-new-suppler/add-new-suppler.component";
import {EditSupplierComponent} from "./user-dashboard/suppliers/edit-supplier/edit-supplier.component";
import {CompaniesComponent} from "./user-dashboard/suppliers/companies/companies.component";
import {AddNewCompanyComponent} from "./user-dashboard/suppliers/companies/add-new-company/add-new-company.component";
import {EditCompanyComponent} from "./user-dashboard/suppliers/companies/edit-company/edit-company.component";
import {AllProductsComponent} from "./user-dashboard/products/all-products/all-products.component";
import {AddNewProductComponent} from "./user-dashboard/products/add-new-product/add-new-product.component";
import {EditProductComponent} from "./user-dashboard/products/edit-product/edit-product.component";
import {BrandsComponent} from "./user-dashboard/brands/brands.component";
import {AllBrandsComponent} from "./user-dashboard/brands/all-brands/all-brands.component";
import {AddBrandComponent} from "./user-dashboard/brands/add-brand/add-brand.component";
import {EditBrandComponent} from "./user-dashboard/brands/edit-brand/edit-brand.component";
import {CategoriesComponent} from "./user-dashboard/categories/categories.component";
import {AllCategoriesComponent} from "./user-dashboard/categories/all-categories/all-categories.component";
import {AddCategoryComponent} from "./user-dashboard/categories/add-category/add-category.component";
import {EditCategoryComponent} from "./user-dashboard/categories/edit-category/edit-category.component";
import {GrnComponent} from "./user-dashboard/grn/grn.component";
import {AddGrnComponent} from "./user-dashboard/grn/add-grn/add-grn.component";
import {GrnHistoryComponent} from "./user-dashboard/grn/grn-history/grn-history.component";
import {StockComponent} from "./user-dashboard/stock/stock.component";
import {InvoiceComponent} from "./user-dashboard/invoice/invoice.component";
import {AddInvoiceComponent} from "./user-dashboard/invoice/add-invoice/add-invoice.component";
import {InvoiceHistoryComponent} from "./user-dashboard/invoice/invoice-history/invoice-history.component";

const routes: Routes = [
    {
        path: "auth", component: AuthComponent, children: [
            {title: 'PoS - Login', path: 'login', component: LoginComponent},
            {title: 'PoS - Forgot Password', path: 'forgot-password', component: ForgotPasswordComponent},
            {title: 'PoS - Reset Password', path: 'reset-password', component: ResetPasswordComponent},
        ], canActivate: [UnauthorizedUserGuard]
    },
    {
        title: "PoS - User Dashboard",
        path: "",
        component: UserDashboardComponent,
        canActivate: [AuthorizedUserGaurd],
        children: [
            {title: "PoS - User Dashboard", path: 'dashboard', component: DashboardComponent},
            {
                title: "PoS - Users",
                path: 'users',
                component: UsersComponent,
                children: [
                    {title: "PoS - All Users", path: "", component: AllUsersComponent},
                    {title: "PoS - Edit User", path: "edit/:userId", component: EditUserComponent},
                    {title: "PoS - Add User", path: "add", component: AddNewUserComponent},
                ],
                canActivate: [AdminAuthGuard],

            },
            {
                title: "PoS - Suppliers",
                path: "suppliers",
                component: SuppliersComponent,
                children: [
                    {title: "PoS - All Suppliers", path: "", component: AllSuppliersComponent},
                    {
                        title: "PoS - Edit Supplier.ts",
                        path: "edit/:supplierId",
                        component: EditSupplierComponent
                    },
                    {title: "PoS - Add Supplier.ts", path: "add", component: AddNewSupplerComponent},
                    {title: "PoS - All Companies", path: "companies", component: CompaniesComponent},
                    {
                        title: "PoS - Add Company",
                        path: "companies/add",
                        component: AddNewCompanyComponent
                    },
                    {
                        title: "PoS - Edit Company",
                        path: "companies/edit/:companyId",
                        component: EditCompanyComponent
                    }
                ],
                canActivate: [AdminAuthGuard]
            },
            {
                title: "PoS - Products", path: 'products', component: ProductsComponent, children: [
                    {title: "PoS - All Products", path: "", component: AllProductsComponent},
                    {title: "PoS - Add Product", path: "add", component: AddNewProductComponent},
                    {title: "PoS - Edit Product", path: "edit/:productId", component: EditProductComponent},
                ], canActivate: [AdminAuthGuard]
            },
            {
                title: "PoS - Brands", path: 'brands', component: BrandsComponent, children: [
                    {title: "PoS - All Brands", path: "", component: AllBrandsComponent},
                    {title: "PoS - Add Brand", path: "add", component: AddBrandComponent},
                    {title: "PoS - Edit Brand", path: "edit/:brandId", component: EditBrandComponent},
                ], canActivate: [AdminAuthGuard]
            },
            {
                title: "PoS - Categories", path: 'categories', component: CategoriesComponent, children: [
                    {title: "PoS - All Categories", path: "", component: AllCategoriesComponent},
                    {title: "PoS - Add Category", path: "add", component: AddCategoryComponent},
                    {
                        title: "PoS - Edit Category",
                        path: "edit/:categoryId",
                        component: EditCategoryComponent
                    }
                ], canActivate: [AdminAuthGuard]
            },
            {
                title: "PoS - GRN", path: 'grn', component: GrnComponent, children: [
                    {title: "PoS - Add GRN", path: "", component: AddGrnComponent},
                    {title: "PoS - GRN History", path: "history", component: GrnHistoryComponent}, // todo: change path
                ]
            },
            {
                title: "PoS - Invoice", path: 'invoice', component: InvoiceComponent, children: [
                    {title: "PoS - Add Invoice", path: "", component: AddInvoiceComponent},
                    {title: "PoS - Invoice History", path: "history", component: InvoiceHistoryComponent},
                ]
            },
            {
                title: "PoS - Stock", path: "stock", component: StockComponent
            }
        ]
    },
    {title: "PoS - Page Not Found", path: "**", component: PageNotFoundComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
